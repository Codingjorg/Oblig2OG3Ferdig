package com.example.arbk2og3webprog;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BilettRepository {

    @Autowired
    public JdbcTemplate database1;



    public List<Bilett> hentAlleBiletter() {
        String sql = "SELECT * FROM Bilett ORDER BY etternavn";
        List<Bilett> alleBiletter = database1.query(sql,new BeanPropertyRowMapper(Bilett.class));
        return alleBiletter;
    }


    int idIncreaser = 3;
    public void lagreBilett(Bilett bilett){
        String sql = "INSERT INTO Bilett (id,film,antall,fornavn,etternavn,telefonnr,epost)" +
                " VALUES(?,?,?,?,?,?,?)";
        database1.update(sql, idIncreaser, bilett.getFilm(),bilett.getAntall(),bilett.getFornavn(),
                bilett.getEtternavn(),bilett.getTelefonnr(),bilett.getEpost());
        idIncreaser++;
    }

    public void slettBilett(int id){
        String sql = "DELETE FROM Bilett WHERE id=?";
        database1.update(sql, id);
    }

    public void slettAlleBiletter () {
        String sql = "DELETE FROM Bilett";
        database1.update(sql);
    }

}
