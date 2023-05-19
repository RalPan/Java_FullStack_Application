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
import we.final_project_thymeleaf_JDBC.model.meals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public class mealDAO implements mealRepo {
    @Autowired
    private final JdbcTemplate jdbcTemp;
    private List<meals> mealsList;

    public mealDAO(JdbcTemplate jdbcTemp) {
        this.jdbcTemp = jdbcTemp;
    }

    @Override
    public void flush() {
    }

    @Override
    public <S extends meals> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends meals> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<meals> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public meals getOne(Integer integer) {
        return null;
    }

    @Override
    public meals getById(Integer integer) {
        return null;
    }

    @Override
    public meals getReferenceById(Integer id) {
        mealsList= findAll();
        for(meals m:mealsList){
            if (m.getMealID() == id){
                return m;
            }
        }
        return null;
    }

    @Override
    public <S extends meals> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends meals> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends meals> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends meals> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends meals> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends meals> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends meals, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends meals> S save(S entity) {
        return null;
    }

    @Override
    public <S extends meals> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<meals> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<meals> findAll() {

        mealsList = jdbcTemp.query("SELECT * FROM meals", new FODMAPMapper());
        return mealsList;
    }

    @Override
    public List<meals> findAllById(Iterable<Integer> integers) {
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
    public void delete(meals entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends meals> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<meals> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<meals> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<meals> findByTolerance(int toleranceID) {
        List<meals> mealList = jdbcTemp.query("SELECT * FROM meals where toleranceID =" + toleranceID + ";", new FODMAPMapper());
        return mealList;
    }

    private static final class FODMAPMapper implements RowMapper<meals> {
        @Autowired
        private toleranceDAO toleranceDAO;
        @Override
        public meals mapRow(ResultSet rs, int rowNum) throws SQLException {
            int tolId = rs.getInt("toleranceID");
            meals meals = new meals(rs.getInt("mealID"), toleranceDAO.getReferenceById(tolId), rs.getString("name"),
                    rs.getString("ingredients"), LocalDateTime.parse(rs.getString("time")));
            return meals;
        }
    }


}
