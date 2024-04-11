import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class CarTravelOptimizer {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int numLocations = input.nextInt();
        int numRoads = input.nextInt();
        List<Location> locations = IntStream.range(0, numLocations).mapToObj(x -> new Location("", x)).collect(Collectors.toList());
        List<List<Road>> roadNetwork = IntStream.range(0, numLocations).mapToObj(x -> new ArrayList<Road>()).collect(Collectors.toList());
        for (int i = 0; i < numRoads; i++)
        {
            int source = input.nextInt();
            locations.get(source).name = input.next();
            int destination = input.nextInt();
            locations.get(destination).name = input.next();
            roadNetwork.get(source).add(new Road(locations.get(destination), input.nextDouble()));
        }
        String startLocationName = input.next();
        Location startLocation = locations.stream().filter(g -> g.name.equals(startLocationName)).findFirst().get();
        String endLocationName = input.next();
        Location endLocation = locations.stream().filter(g -> g.name.equals(endLocationName)).findFirst().get();
        PriorityQueue<Road> priorityQueue = new PriorityQueue<>();
        double[] travelTime = DoubleStream.generate(() -> Double.MAX_VALUE).limit(numLocations).toArray();
        Location[] backtrack = new Location[numLocations];
        backtrack[startLocation.ID] = null;
        travelTime[startLocation.ID] = 0;
        priorityQueue.add(new Road(startLocation, 0));
        optimizeTravel(roadNetwork, priorityQueue, backtrack, travelTime);
        Location[] backtrack2 = new Location[numLocations];
        double[] travelTime2 = DoubleStream.generate(() -> Double.MAX_VALUE).limit(numLocations).toArray();
        backtrack2[endLocation.ID] = null;
        travelTime2[endLocation.ID] = travelTime[endLocation.ID];
        priorityQueue.clear();
        priorityQueue.add(new Road(endLocation, travelTime2[endLocation.ID]));
        optimizeTravel(roadNetwork, priorityQueue, backtrack2, travelTime2);
        Deque<Location> pathStack = new LinkedList<>();
        Location pointer = endLocation;
        while (pointer != null)
        {
            pathStack.push(pointer);
            pointer = backtrack[pointer.ID];
        }
        while (!pathStack.isEmpty()) System.out.print(pathStack.pop().name + " ");
        System.out.println();
        pointer = startLocation;
        while (pointer != null)
        {
            pathStack.push(pointer);
            pointer = backtrack2[pointer.ID];
        }
        while (!pathStack.isEmpty()) System.out.print(pathStack.pop().name + " ");
        System.out.println();
        System.out.println(travelTime2[startLocation.ID]);
    }

    private static void optimizeTravel(List<List<Road>> roadNetwork, PriorityQueue<Road> priorityQueue, Location[] backtrack, double[] travelTime)
    {
        while (!priorityQueue.isEmpty())
        {
            Road current = priorityQueue.poll();
            roadNetwork.get(current.location.ID)
                    .stream()
                    .filter(candidate -> travelTime[current.location.ID] + candidate.travelDuration < travelTime[candidate.location.ID])
                    .forEach(candidate -> {
                        travelTime[candidate.location.ID] = travelTime[current.location.ID] + candidate.travelDuration;
                        backtrack[candidate.location.ID] = current.location;
                        priorityQueue.add(new Road(candidate.location, travelTime[candidate.location.ID]));
                    });
        }
    }

    private static class Road implements Comparable<Road>
    {
        Location location;
        double travelDuration;

        public Road(Location location, double travelDuration)
        {
            this.location = location;
            this.travelDuration = travelDuration;
        }

        public int compareTo(Road other)
        {
            return Double.compare(travelDuration, other.travelDuration);
        }
    }

    private static class Location
    {
        String name;
        int ID;

        public Location(String name, int ID)
        {
            this.name = name;
            this.ID = ID;
        }
    }
}