package we.final_project_thymeleaf_JDBC.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import we.final_project_thymeleaf_JDBC.model.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public class userDAO implements userRepo{
    @Autowired
    private final JdbcTemplate jdbcTemp;

    public userDAO(JdbcTemplate jdbcTemp) {
        this.jdbcTemp = jdbcTemp;
    }

    @Override
    public int findByName(String name) {
        //could add "and password = ?" to authentificate user
        List<user> userList = jdbcTemp.query("SELECT * FROM users where user_name ='" + name + "';", new FODMAPMapper());
        if (userList.isEmpty()){
            return 0;
        }
        return userList.get(0).getUserID();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends user> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends user> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<user> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public user getOne(Integer integer) {
        return null;
    }

    @Override
    public user getById(Integer integer) {
        return null;
    }

    @Override
    public user getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends user> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends user> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends user> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends user> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends user> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends user> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends user, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends user> S save(S entity) {
        return null;
    }

    @Override
    public <S extends user> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<user> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<user> findAll() {
        return null;
    }

    @Override
    public List<user> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(user entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends user> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<user> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<user> findAll(Pageable pageable) {
        return null;
    }

    private static final class FODMAPMapper implements RowMapper<user> {

        @Override
        public user mapRow(ResultSet rs, int rowNum) throws SQLException {
            user user = new user(rs.getInt("userID"),rs.getString("user_name"), rs.getString("contact"));
            return user;
        }
    }
}
