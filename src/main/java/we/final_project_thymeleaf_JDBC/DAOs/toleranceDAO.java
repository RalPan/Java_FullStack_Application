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
import we.final_project_thymeleaf_JDBC.model.tolerance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public class toleranceDAO implements toleranceRepo {

    @Autowired
    private final JdbcTemplate jdbcTemp;

    private List<tolerance> toleranceList;

    public toleranceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemp = jdbcTemplate;
    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends tolerance> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends tolerance> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<tolerance> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public tolerance getOne(Integer integer) {
        return null;
    }

    @Override
    public tolerance getById(Integer integer) {
        return null;
    }

    @Override
    public tolerance getReferenceById(Integer id) {
        toleranceList= findAll();

        for(tolerance t:toleranceList){

            if (t.getToleranceID() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public <S extends tolerance> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends tolerance> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends tolerance> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends tolerance> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends tolerance> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends tolerance> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends tolerance, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends tolerance> S save(S entity) {
        return null;
    }

    @Override
    public <S extends tolerance> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<tolerance> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<tolerance> findAll() {
        toleranceList = jdbcTemp.query("SELECT * FROM tolerance", new FODMAPMapper());
        return toleranceList;
    }

    @Override
    public List<tolerance> findAllById(Iterable<Integer> integers) {
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
    public void delete(tolerance entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends tolerance> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<tolerance> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<tolerance> findAll(Pageable pageable) {
        return null;
    }
    private static final class FODMAPMapper implements RowMapper<tolerance> {
        @Autowired
        private userDAO userDAO;
        @Override
        public tolerance mapRow(ResultSet rs, int rowNum) throws SQLException {
            int userID = rs.getInt("fk_userID");

            tolerance tolerance = new tolerance(rs.getInt("toleranceID"), userDAO.getReferenceById(userID),
                    rs.getInt("Fructose"), rs.getInt("Lactose"), rs.getInt("Sorbitol"), rs.getInt("Mannitol"),
                    rs.getInt("GOS"),rs.getInt("Fructans"));
            return tolerance;
        }
    }
}
