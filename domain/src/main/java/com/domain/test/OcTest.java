package com.domain.test;

import com.domain.model.Car;
import com.domain.model.Customer;
import com.domain.model.CustomerImpl;
import com.domain.model.Discount;
import com.domain.model.DiscountImpl;
import com.domain.model.Oc;
import com.domain.model.User;
import com.domain.model.UserImpl;
import com.domain.model.Vehicle;
import com.domain.model.Zone;
import com.domain.model.ZoneImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OcTest {

    private Oc oc;
    private Customer customer;
    private Vehicle car;
    private Collection<Discount> discounts = new List<Discount>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Discount> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Discount discount) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Discount> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Discount> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Discount get(int index) {
            return null;
        }

        @Override
        public Discount set(int index, Discount element) {
            return null;
        }

        @Override
        public void add(int index, Discount element) {

        }

        @Override
        public Discount remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Discount> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Discount> listIterator(int index) {
            return null;
        }

        @Override
        public List<Discount> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    private Zone zone;
    private User user;

    @Before
    public void setUp() throws Exception {
        /*Discounts*/
        DiscountImpl discount1 = new DiscountImpl("New car");
        discount1.setType(Discount.Type.ADD);
        discount1.setValue(50.0f);

        DiscountImpl discount2 = new DiscountImpl("Disabled");
        discount2.setType(Discount.Type.MULTIPLY);
        discount2.setValue(0.5f);

        this.discounts.add(discount1);
        this.discounts.add(discount2);

        /*Car*/
        Car car = new Car("ASD 5256");
        car.setBrand("Audi");
        car.setModel("A4");
        car.setVin("ASPLEMD1236521012");
        car.setCapacity(1.2f);

        this.car = car;

        /*Zone*/
        ZoneImpl zone = new ZoneImpl(1);
        zone.setZoneType(Zone.Type.ADD);

        this.zone = zone;

        /*Customer*/
        CustomerImpl customer = new CustomerImpl("9876541231");
        customer.setCity("Warsaw");
        customer.setHouseNumber("5");
        customer.setName("Jan");
        customer.setSurname("Abc");
        customer.setStreet("Xyz");

        /*User*/
        UserImpl user = new UserImpl("X001");
        user.setSurname("Smith");
        user.setName("John");

        /*Oc*/
        this.oc = new Oc("0266");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSetCustomer() throws Exception {
        oc.setCustomer(this.customer);
        Assert.assertEquals(this.customer, oc.getCustomer());
    }

    @Test
    public void testSetVehicle() throws Exception {
        oc.setVehicle(this.car);
        Assert.assertEquals(this.car, oc.getVehicle());
    }

    @Test
    public void testSetDiscounts() throws Exception {
        oc.setDiscounts(this.discounts);
        Assert.assertEquals(this.discounts, oc.getDiscounts());
    }

    @Test
    public void testSetInsurer() throws Exception {
        oc.setInsurer(this.user);
        Assert.assertEquals(this.user, oc.getInsurer());
    }

}