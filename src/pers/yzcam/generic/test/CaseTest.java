package pers.yzcam.generic.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.generic.entity.Car;
import pers.yzcam.generic.entity.Ship;
import pers.yzcam.generic.util.AggregateSupporter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 */
public class CaseTest {
    @Test
    void carTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("0001", "北京", "white"));
        carList.add(new Car("0002", "湖北", "red"));
        carList.add(new Car("0003", "安徽", "blue"));
        carList.add(new Car("0004", "天津", "black"));
        carList.add(new Car("0005", "上海", "grey"));
        /*
        对不符合泛型规定的类型存储将在编译时报错
         */
        /* carList.add(new File("")); */

        for (Car car : carList) {
            System.out.println(car.getCarNumber() + "\t" + car.getPosition() + "\t" + car.getColor());
        }
    }

    @Test
    void getClassNameTest() {
        AggregateSupporter<Car> carAggregateSupporter = new AggregateSupporter<>();
        AggregateSupporter<Ship> shipAggregateSupporter = new AggregateSupporter<>();

        Car car = new Car();
        System.out.println(carAggregateSupporter.getClassName(car));

        Ship ship = new Ship();
        System.err.println(shipAggregateSupporter.getClassName(ship));
    }
}
