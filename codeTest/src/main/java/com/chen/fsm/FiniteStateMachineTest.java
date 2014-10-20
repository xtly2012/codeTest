package com.chen.fsm;

public class FiniteStateMachineTest {

	public static boolean reset = false;

	public static boolean sig1 = true;

	public static boolean sig2 = false;

	public static boolean sig3 = true;

	public static String q_sig4 = "idle";

	public static int q_sm_state = 0;

	public static int IDLE = 0;

	public static int WAIT = 1;

	public static int DONE = 2;

	public static void main(String[] argus) {
		if (reset) {
			q_sig4 = "idle";
			q_sm_state = IDLE;
		} else {
			if (q_sm_state == IDLE) {
				if (sig1 || sig2) {
					q_sm_state = WAIT;
					q_sig4 = "wait";
				} else {
					q_sm_state = IDLE;
					q_sig4 = "idle";
				}
			} else if (q_sm_state == WAIT) {
				if (sig2 && sig3) {
					q_sm_state = DONE;
					q_sig4 = "done";
				} else {
					q_sm_state = WAIT;
					q_sig4 = "wait";
				}
			} else if (q_sm_state == DONE) {
				if (sig3) {
					q_sm_state = IDLE;
					q_sig4 = "idle";
				} else {
					q_sm_state = DONE;
					q_sig4 = "done";
				}
			} else {
				q_sm_state = IDLE;
				q_sig4 = "idle";
			}
		}
		
		System.out.println(q_sig4);
		System.out.println(q_sm_state);
	}
}
