package ca.ubc.cs304.entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerCountryEntity implements Entity{

    private final String Country;
    private final int Count;

    public CustomerCountryEntity(String country, int count) {
        this.Country = country;
        this.Count = count;
    }

    public String getCountry() {
        return Country;
    }

    public int getCount() {
        return Count;
    }

    public static List<CustomerCountryEntity> mapFromResultSet(ResultSet rs) {
        ArrayList<CustomerCountryEntity> result = new ArrayList<CustomerCountryEntity>();
        try {
            while (rs.next()) {
                CustomerCountryEntity item = new CustomerCountryEntity(rs.getString("Country"),
                        rs.getInt("Count")
                );
                result.add(item);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Exception:" + " " + e.getMessage());
        }
        return result;
    }

    @Override
    public String toString() {
        return "CustomerCountrEntity{" +
                ", Country='" + Country + '\'' +
                ", Count=" + Count +
                '}';
    }
}