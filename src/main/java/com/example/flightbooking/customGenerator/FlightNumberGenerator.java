package com.example.flightbooking.customGenerator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FlightNumberGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object o) {
        String prefix = "FN";
        String suffix = "";
        try {
            Connection con = session.getJdbcConnectionAccess().obtainConnection();
            Statement stmt = con.createStatement();
            String sql = "select * from t_flight_seq";

            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                int val = rs.getInt(1);
                suffix=String.valueOf(1000+val);
                val++;
                sql="UPDATE t_flight_seq SET next_val = "+val+";";
                stmt.execute(sql);
            }


        }

        catch (Exception e){
            e.printStackTrace();
        }
        return prefix+suffix;
    }
}
