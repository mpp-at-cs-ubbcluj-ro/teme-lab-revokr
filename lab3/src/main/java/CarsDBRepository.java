import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class CarsDBRepository implements CarRepository{

    private JdbcUtils dbUtils;



    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement stm = conn.prepareStatement("SELECT * FROM \"masina\" WHERE manufacturer= " + "\'" +manufacturerN + "\'")) {
            try (ResultSet result = stm.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturerN, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error db: " + e.getMessage());
        }

        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
	//to do
        return null;
    }

    @Override
    public void add(Car elem) {
        Connection conn = dbUtils.getConnection();
        try (PreparedStatement stm = conn.prepareStatement("INSERT INTO \"masina\" VALUES(?, ?, ?, ?)")) {
            stm.setInt(1, elem.getId());
            stm.setString(2, elem.getManufacturer());
            stm.setString(3, elem.getModel());
            stm.setInt(4, elem.getYear());
            int res = stm.executeUpdate();
            logger.trace("Saved {} instances", res);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error db: " + e.getMessage());
        }
    }

    @Override
    public void update(Integer integer, Car elem) {
        Connection conn = dbUtils.getConnection();
        try (PreparedStatement stm = conn.prepareStatement("UPDATE \"masina\" SET manufacturer=" + "\'" +elem.getManufacturer() + "\'" + ", model=" + "\'" + elem.getModel() + "\'" + " WHERE id=" +elem.getId())) {
            int rez = stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Car> findAll() {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement stm = conn.prepareStatement("SELECT * FROM \"masina\" ")) {
            try (ResultSet result = stm.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error db: " + e.getMessage());
        }

        return cars;
    }
}
