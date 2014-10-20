package com.chen.fsm;

public class FiniteStateMachineTest3 {
	public static boolean reset = false;

	public static boolean sig1 = true;

	public static boolean sig2 = false;

	public static boolean sig3 = true;

	public static String q_sig4 = "idle";

	public static int current_state = 0;
	
	public static int next_state = 0;

	public static int IDLE = 0;

	public static int WAIT = 1;

	public static int DONE = 2;
	
	//状态跳转程序设计
	public static void stateChange(boolean reset) {
		if (reset) {
			current_state = IDLE;
		} else {
			current_state = next_state;
		}
	}
	
	//状态跳转输出
	public static void outputState(int current_state, boolean sig1, boolean sig2, boolean sig3) {
		if (current_state == IDLE) {
			if (sig1 || sig2) {
				current_state = WAIT;
				q_sig4 = "wait";
			} else {
				current_state = IDLE;
				q_sig4 = "idle";
			}
		} else if (current_state == WAIT) {
			if (sig2 && sig3) {
				current_state = DONE;
				q_sig4 = "done";
			} else {
				current_state = WAIT;
				q_sig4 = "wait";
			}
		} else if (current_state == DONE) {
			if (sig3) {
				current_state = IDLE;
				q_sig4 = "idle";
			} else {
				current_state = DONE;
				q_sig4 = "done";
			}
		} else {
			current_state = IDLE;
			q_sig4 = "idle";
		}
	}
	
	//逻辑输出
	public static void outputLogic(boolean reset) {
		if (reset) {
			q_sig4 = "idle";
		} else {
			if (next_state == IDLE) {
				q_sig4 = "idle";
			} else if (next_state == WAIT) {
				q_sig4 = "wait";
			} else if (next_state == DONE) {
				q_sig4 = "done";
			} else {
				q_sig4 = "idle";
			}
		}
		
	}

	public static void main(String[] argus) {
		
	}
}
