package jc.ejemplo.db_01_02.data;

import jc.ejemplo.db_01_02.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class PersonaRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public String nombre(int id){
        // Solo por hacerlo diferente. Deberia usarse queryForObject
        return jdbcTemplate.query("select * from persona where id=?", this::personaRowMapper, id).get(0).getNombre();
    }

    public Persona persona(int id){
        return jdbcTemplate.queryForObject("select * from persona where id=?", this::personaRowMapper, id);
    }

    private Persona personaRowMapper(ResultSet resultSet, int id) throws SQLException {
        Persona persona = new Persona();
        persona.setId(resultSet.getInt("ID"));
        persona.setNombre(resultSet.getString("NOMBRE"));
        persona.setApellido(resultSet.getString("APELLIDO"));
        return persona;
    }
}



/*
// Otra forma para implementar el mapper en una clase (pre java 8 - en lugar de pasar el this::personaRowMapper)
class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    User user = new User();
    user.setId(rs.getInt("id"));
    user.setName(rs.getString("name"));
    user.setEmail(rs.getString("email"));
    return user;
    }
}
*/