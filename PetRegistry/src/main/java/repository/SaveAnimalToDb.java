package repository;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;
import repository.db.Const;
import repository.db.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveAnimalToDb implements SaveAnimal {

    private DatabaseHandler databaseHandler;

    @Override
    public void saveAnimal(Animal animal) throws SQLException, ClassNotFoundException {
        PreparedStatement prSt = null;
        if (animal instanceof Dog) {
            String insert = "INSERT INTO " + Const.DOGS_TABLE + "(" +
                    Const.DOG_ID + "," + Const.DOG_NAME + "," +
                    Const.DOG_COMMANDS + "," + Const.DOG_DATE_BIRTH + "," +
                    Const.DOG_KIND_ID + ")" +
                    "VALUES(?,?,?,?,?);";
            prSt = databaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setString(1, ((Dog) animal).getId().toString());
            prSt.setString(2, ((Dog) animal).getName());
            prSt.setString(3, String.join(",", ((Dog) animal).getCommands()));
            prSt.setString(4, ((Dog) animal).getDateBirth());
            prSt.setString(5, ((Dog) animal).getKindId().toString());
        } else if (animal instanceof Cat) {
            String insert = "INSERT INTO " + Const.CATS_TABLE + "(" +
                    Const.CAT_ID + "," + Const.CAT_NAME + "," +
                    Const.CAT_COMMANDS + "," + Const.CAT_DATE_BIRTH + "," +
                    Const.CAT_KIND_ID + ")" +
                    "VALUES(?,?,?,?,?);";
            prSt = databaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setString(1, ((Cat) animal).getId().toString());
            prSt.setString(2, ((Cat) animal).getName());
            prSt.setString(3, String.join(",", ((Cat) animal).getCommands()));
            prSt.setString(4, ((Cat) animal).getDateBirth());
            prSt.setString(5, ((Cat) animal).getKindId().toString());
        } else if (animal instanceof Hamster) {
            String insert = "INSERT INTO " + Const.HAMSTERS_TABLE + "(" +
                    Const.HAMSTER_ID + "," + Const.HAMSTER_NAME + "," +
                    Const.HAMSTER_COMMANDS + "," + Const.HAMSTER_DATE_BIRTH + "," +
                    Const.HAMSTER_KIND_ID + ")" +
                    "VALUES(?,?,?,?,?);";
            prSt = databaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setString(1, ((Hamster) animal).getId().toString());
            prSt.setString(2, ((Hamster) animal).getName());
            prSt.setString(3, String.join(",", ((Hamster) animal).getCommands()));
            prSt.setString(4, ((Hamster) animal).getDateBirth());
            prSt.setString(5, ((Hamster) animal).getKindId().toString());
        }
        assert prSt != null;
        prSt.executeUpdate();
    }
}
