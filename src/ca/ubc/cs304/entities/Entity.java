package ca.ubc.cs304.entities;

import java.sql.ResultSet;
import java.util.List;

public interface Entity {
    static List<ItemEntity> mapFromResultSet(ResultSet rs) {
        return null;
    }
}
