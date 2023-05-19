package we.final_project_thymeleaf_JDBC.DAOs;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import we.final_project_thymeleaf_JDBC.model.ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Repository
public class ingredientsDAO implements ingredientRepo {
    @Autowired
    private final JdbcTemplate jdbcTemp;
    private List<ingredients> ingredientsList;

    public ingredientsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemp = jdbcTemplate;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ingredients> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ingredients> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ingredients> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ingredients getOne(Integer integer) {
        return null;
    }

    @Override
    public ingredients getById(Integer integer) {
        return null;
    }

    @Override
    public ingredients getReferenceById(Integer id) {
        ingredientsList= findAll();
        for(ingredients ingredient:ingredientsList){
            if (ingredient.getIngredientID() == id){
                return ingredient;
            }
        }
        return null;
    }
    @Override
    public <S extends ingredients> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ingredients> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ingredients> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ingredients> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ingredients> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ingredients> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ingredients, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ingredients> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ingredients> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ingredients> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<ingredients> findAll() {
        ingredientsList = jdbcTemp.query("SELECT * FROM ingredients", new FODMAPMapper());
        return ingredientsList;
    }

    @Override
    public List<ingredients> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        ingredientsList = jdbcTemp.query("SELECT * FROM ingredients", new FODMAPMapper());
        return ingredientsList.stream().count();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ingredients entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ingredients> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ingredients> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ingredients> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public ingredients findByName(String name) {
            List<ingredients> userList = jdbcTemp.query("SELECT * FROM ingredients where name ='" + name + "';", new FODMAPMapper());
            //improvement, return the full list and let the user choose from the options
            return userList.get(0);

    }

    private static final class FODMAPMapper implements RowMapper<ingredients> {

        @Override
        public ingredients mapRow(ResultSet rs, int rowNum) throws SQLException {
            ingredients ingredients = new ingredients(rs.getInt("ingredientID"), rs.getString("name"),
                    rs.getInt("quantity"), rs.getString("unit"), rs.getInt("Fructose"), rs.getInt("Lactose"),
                    rs.getInt("Sorbitol"), rs.getInt("Mannitol"), rs.getInt("GOS"),rs.getInt("Fructans"));
            return ingredients;
        }
    }
}
