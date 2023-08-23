package ca.ubc.cs304.entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemCountEntity implements Entity{

    private final String Sector;
    private final int Count;

    public ItemCountEntity(String sector, int count) {
        this.Sector = sector;
        this.Count = count;
    }

    public String getSector() {
        return Sector;
    }

    public int getCount() {
        return Count;
    }

    public static List<ItemCountEntity> mapFromResultSet(ResultSet rs) {
        ArrayList<ItemCountEntity> result = new ArrayList<ItemCountEntity>();
        try {
            while (rs.next()) {
                ItemCountEntity item = new ItemCountEntity(rs.getString("Sector"),
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
        return "ItemCountEntity{" +
                ", Sector='" + Sector + '\'' +
                ", Count=" + Count +
                '}';
    }
}