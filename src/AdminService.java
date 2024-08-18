import java.util.*;

public class AdminService {

        List<Master> masters = new ArrayList<>();
        List<Garage> garages = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        void addMaster(String name) {
            masters.add(new Master(name));
        }

        void removeMaster(String name) {
            for (Iterator<Master> iterator = masters.iterator(); iterator.hasNext();) {
                Master master = iterator.next();
                if (master.name.equals(name)) {
                    iterator.remove();
                }
            }
        }

        void addGarage(int id) {
            garages.add(new Garage(id));
        }

        void removeGarage(int id) {
            for (Iterator<Garage> iterator = garages.iterator(); iterator.hasNext();) {
                Garage garage = iterator.next();
                if (garage.id == id) {
                    iterator.remove();
                }
            }
        }

        void addOrder(int id, Date submissionDate, Date plannedStartDate, double price) {
            orders.add(new Order(id, submissionDate, plannedStartDate, price));
        }

        void removeOrder(int id) {
            for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
                Order order = iterator.next();
                if (order.id == id) {
                    iterator.remove();
                }
            }
        }

        void closeOrder(int id) {
            for (Order order : orders) {
                if (order.id == id) {
                    order.status = "Closed";
                }
            }
        }

        void cancelOrder(int id) {
            for (Order order : orders) {
                if (order.id == id) {
                    order.status = "Cancelled";
                }
            }
        }

        List<Garage> listFreeGarages() {
            List<Garage> freeGarages = new ArrayList<>();
            for (Garage garage : garages) {
                if (garage.isFree) {
                    freeGarages.add(garage);
                }
            }
            return freeGarages;
        }

        List<Order> listOrders(String sortBy) {
            List<Order> sortedOrders = new ArrayList<>(orders);
            Collections.sort(sortedOrders, new Comparator<Order>() {
                public int compare(Order o1, Order o2) {
                    switch (sortBy) {
                        case "submissionDate":
                            return o1.submissionDate.compareTo(o2.submissionDate);
                        case "completionDate":
                            return o1.completionDate.compareTo(o2.completionDate);
                        case "plannedStartDate":
                            return o1.plannedStartDate.compareTo(o2.plannedStartDate);
                        case "price":
                            return Double.compare(o1.price, o2.price);
                        default:
                            return 0;
                    }
                }
            });
            return sortedOrders;
        }

        List<Master> listMasters(String sortBy) {
            List<Master> sortedMasters = new ArrayList<>(masters);
            Collections.sort(sortedMasters, new Comparator<Master>() {
                public int compare(Master m1, Master m2) {
                    switch (sortBy) {
                        case "name":
                            return m1.name.compareTo(m2.name);
                        case "isBusy":
                            return Boolean.compare(m1.isBusy, m2.isBusy);
                        default:
                            return 0;
                    }
                }
            });
            return sortedMasters;
        }

        List<Order> listCurrentOrders(String sortBy) {
            List<Order> currentOrders = new ArrayList<>();
            for (Order order : orders) {
                if (order.status.equals("Open")) {
                    currentOrders.add(order);
                }
            }
            Collections.sort(currentOrders, new Comparator<Order>() {
                public int compare(Order o1, Order o2) {
                    switch (sortBy) {
                        case "submissionDate":
                            return o1.submissionDate.compareTo(o2.submissionDate);
                        case "completionDate":
                            return o1.completionDate.compareTo(o2.completionDate);
                        case "price":
                            return Double.compare(o1.price, o2.price);
                        default:
                            return 0;
                    }
                }
            });
            return currentOrders;
        }

        List<Order> listOrdersByMaster(String masterName) {
            List<Order> ordersByMaster = new ArrayList<>();
            for (Order order : orders) {
                if (order.assignedMaster != null && order.assignedMaster.name.equals(masterName)) {
                    ordersByMaster.add(order);
                }
            }
            return ordersByMaster;
        }

        List<Master> listMastersByOrder(int orderId) {
            List<Master> mastersByOrder = new ArrayList<>();
            for (Order order : orders) {
                if (order.id == orderId && order.assignedMaster != null) {
                    mastersByOrder.add(order.assignedMaster);
                }
            }
            return mastersByOrder;
        }

        List<Order> listOrdersByStatusAndDateRange(String status, Date startDate, Date endDate, String sortBy) {
            List<Order> ordersByStatusAndDateRange = new ArrayList<>();
            for (Order order : orders) {
                if (order.status.equals(status) && order.submissionDate.after(startDate) && order.submissionDate.before(endDate)) {
                    ordersByStatusAndDateRange.add(order);
                }
            }
            Collections.sort(ordersByStatusAndDateRange, new Comparator<Order>() {
                public int compare(Order o1, Order o2) {
                    switch (sortBy) {
                        case "submissionDate":
                            return o1.submissionDate.compareTo(o2.submissionDate);
                        case "completionDate":
                            return o1.completionDate.compareTo(o2.completionDate);
                        case "price":
                            return Double.compare(o1.price, o2.price);
                        default:
                            return 0;
                    }
                }
            });
            return ordersByStatusAndDateRange;
        }

        int countFreeSpacesOnDate(Date date) {
            int freeMasters = 0;
            for (Master master : masters) {
                if (!master.isBusy) {
                    freeMasters++;
                }
            }
            int freeGarages = 0;
            for (Garage garage : garages) {
                if (garage.isFree) {
                    freeGarages++;
                }
            }
            return Math.min(freeMasters, freeGarages);
        }

        Date findNextFreeDate() {
            Calendar c = Calendar.getInstance();
            while (countFreeSpacesOnDate(c.getTime()) == 0) {
                c.add(Calendar.DATE, 1);
            }
            return c.getTime();

    }

}
