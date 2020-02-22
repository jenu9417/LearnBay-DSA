package com.jenu.lbdsa.t5.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/*

ActivitySelectionProblem
------------------------

Find list of activities that can be performed without conflicting each other.
Greedy Approach. Sort the activities by finish time. Select the acitivity if
start time is less than previous activities finish time.

Not optimal always.

Time  : O(n)
Space : O(n)

*/
public class ActivitySelectionProblem {
	
	static List<Activity> selectActivities(List<Activity> activities) {
		final List<Activity> selectedActivities = new ArrayList<>();
		
		Collections.sort(activities, new Comparator<Activity>() {
			public int compare(Activity o1, Activity o2) {
				return Integer.compare(o1.finish, o2.finish);
			}
		});
		
		final Iterator<Activity> activityIterator = activities.iterator();
		Activity previousActivity = activityIterator.next();
		selectedActivities.add(previousActivity);
		
		while(activityIterator.hasNext()) {
			Activity currentActivity = activityIterator.next();
			if(currentActivity.start > previousActivity.finish) {
				selectedActivities.add(currentActivity);
				previousActivity = currentActivity;
			}
		}
		
		return selectedActivities;
	}
	
	public static void main(String[] args) {
		final List<Activity> activities = new ArrayList<>();
		activities.add(new Activity(1, 4));
		activities.add(new Activity(3, 5));
		activities.add(new Activity(0, 6));
		activities.add(new Activity(5, 7));
		activities.add(new Activity(3, 8));
		activities.add(new Activity(5, 9));
		activities.add(new Activity(6, 10));
		activities.add(new Activity(8, 11));
		activities.add(new Activity(8, 12));
		activities.add(new Activity(2, 13));
		activities.add(new Activity(12, 14));
		
		final List<Activity> selectedActivities = selectActivities(activities);
		selectedActivities.stream().forEach(x -> System.out.printf("Start : %d    Finish : %d\n", x.start, x.finish));
		
	}
	
	static class Activity {
		int start;
		int finish;
		
		public Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
	}

}
