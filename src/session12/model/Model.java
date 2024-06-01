package session12.model;

import session12.entity.Entity;
import session12.MySQLConnectionDB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Model<T extends Entity<?>> implements ModelDAO{
    private final Connection conn = MySQLConnectionDB.getMyConnection();
    PreparedStatement pstm = null;

    public Model() throws SQLException {
    }

    private String getTableName(Class<T> entityClass){
        String tableName = entityClass.getSimpleName();
        return tableName;
    }
    private StringBuilder queryInsert(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("insert into ");
        query.append(tableName).append(" (");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i<fields.length;i++){
            if (i>0){
                query.append(", ");
            }
            query.append(fields[i].getName());
        }
        query.append(") values (");
        for (int i = 0 ; i<fields.length;i++){
            if (i>0){
                query.append(", ");
            }
            query.append("?");
        }
        query.append(")");
        return query;
    }
    private StringBuilder queryUpdate(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("update ");
        query.append(tableName).append(" set ");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 1 ; i< fields.length;i++){
            if (i > 1){
                query.append(", ");
            }
            query.append(fields[i].getName()).append(" = ?");
        }
        query.append(" where ").append(fields[0].getName()).append(" = ?");
        return query;
    }
    private StringBuilder queryDelete(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("delete from ");
        query.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        query.append(fields[0].getName()).append(" = ?");
        return query;
    }
    private StringBuilder queryGetAll(Class<T> entityClass) {
        String tableName = getTableName(entityClass);
        StringBuilder query = new StringBuilder("select * from ");
        query.append(tableName);
        return query;
    }
    private StringBuilder queryGetEntityById(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("select * from ");
        query.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        query.append(fields[0].getName()).append(" = ?");
        return query;
    }


    @Override
    public void create(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryInsert(entity).toString();
        pstm = conn.prepareStatement(query, pstm.RETURN_GENERATED_KEYS);
        int parameterIndex = 1;
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(entity);
            pstm.setObject(parameterIndex++, value);
        }

        int rowAffected = pstm.executeUpdate();
        if (rowAffected > 0) {
            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedKey = generatedKeys.getInt(1);
                entity.setId(generatedKey);
            }else {
                throw new SQLException("Failed to insert entity");
            }
        }else {
            throw new SQLException("Failed to insert entity");
        }
    }

    @Override
    public Entity<?> getById(int id) throws SQLException {
        return null;
    }

    @Override
    public List getAll() throws SQLException {
        return List.of();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public void update(Entity entity) throws SQLException {

    }
}
