import java.util.*;

class RideSharingSystem {
    Deque<Integer> riders;
    Deque<Integer> drivers;
    Set<Integer> activeRiders;
    Set<Integer> canceledRiders;

    public RideSharingSystem() {
        riders = new ArrayDeque<>();
        drivers = new ArrayDeque<>();
        activeRiders = new HashSet<>();
        canceledRiders = new HashSet<>();
    }

    public void addRider(int riderId) {
        riders.offer(riderId);
        activeRiders.add(riderId);
    }

    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }

    public int[] matchDriverWithRider() {
        while (!riders.isEmpty() && canceledRiders.contains(riders.peek())) {
            int r = riders.poll();
            canceledRiders.remove(r);
            activeRiders.remove(r);
        }

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[] { -1, -1 };
        }

        int r = riders.poll();
        int d = drivers.poll();
        activeRiders.remove(r);
        return new int[] { d, r };
    }

    public void cancelRider(int riderId) {
        if (activeRiders.contains(riderId)) {
            canceledRiders.add(riderId);
        }
    }
}
