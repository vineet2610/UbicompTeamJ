import java.util.Date;

import edu.ufl.digitalworlds.j4k.J4KSDK;

/**
 * 
 */

/**
 * @author Prateek
 *
 */
public class SkeletonTracker extends J4KSDK
{
	int counter=0;
	long time=0;
	
	@Override
	public void onSkeletonFrameEvent(boolean[] skeleton_tracked, float[] positions, float[] orientations, byte[] joint_status) {
		System.out.println("A new skeleton frame was received.");
	}

	@Override
	public void onColorFrameEvent(byte[] color_frame) {
		System.out.println("A new color frame was received.");
	}

	@Override
	public void onDepthFrameEvent(short[] depth_frame, byte[] body_index, float[] xyz, float[] uv) {
		System.out.println("A new depth frame was received.");
		
		if(counter==0)
			time=new Date().getTime();
		counter+=1;
	}
	
	public static void main(String[] args)
	{
		
		if(System.getProperty("os.arch").toLowerCase().indexOf("64")<0)
		{
			System.out.println("WARNING: You are running a 32bit version of Java.");
			System.out.println("This may reduce significantly the performance of this application.");
			System.out.println("It is strongly adviced to exit this program and install a 64bit version of Java.\n");
		}
		
		System.out.println("This program will run for about 20 seconds.");
		SkeletonTracker kinect=new SkeletonTracker();
		kinect.start(J4KSDK.COLOR|J4KSDK.DEPTH|J4KSDK.SKELETON);
		
		
		//Sleep for 20 seconds.
		try {Thread.sleep(20000);} catch (InterruptedException e) {}
		
		
		kinect.stop();		
		System.out.println("FPS: "+kinect.counter*1000.0/(new Date().getTime()-kinect.time));
	}

}
