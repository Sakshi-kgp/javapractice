import java.util.Scanner;

class GoBackN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of frames: ");
        int totalFrames = sc.nextInt();

        System.out.print("Enter window size: ");
        int sw = sc.nextInt();

        int sf = 0; // Sequence number of first frame in window
        int sn = 0; // Sequence number of next frame to send

        while (sf < totalFrames) {
            // SENDER SIDE
            while (sn < sf + sw && sn < totalFrames) {
                System.out.println("Sender: Sending Frame " + sn);
                sn++;
            }

            // RECEIVER SIDE
            System.out.print("Enter lost frame number (-1 if none lost): ");
            int lostFrame = sc.nextInt();

            if (lostFrame == -1) {
                System.out.println("Receiver: All frames received successfully");
                System.out.println("Sender: ACK received, sliding window");
                sf = sn;
            } else {
                System.out.println("Receiver: Frame " + lostFrame + " lost");
                System.out.println("Sender: Timeout occurred");
                System.out.println("Sender: Retransmitting from Frame " + lostFrame);

                // Go-Back-N: Reset both pointers to the lost frame
                sf = lostFrame;
                sn = lostFrame;
            }
        }

        System.out.println("\nAll frames transmitted successfully");
        sc.close();
    }
}