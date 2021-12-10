/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function.operating;

class PCB{       //进程的pcb
	int name;    //进程名
	int level;   //优先级
	int AT;         //到达时间
	int RT;	 		//需要运行时间
	int CPUT=0;		//已用CPU时间
	char State;     //进程状态
	PCB(){}
	PCB(int a,int b,int c){
		name=a;
		AT=b;
		RT=c;
	}
	PCB(int a,int b,int c,int d){
		name=a;
		AT=b;
		RT=c;
		level=d;
	}
}

class Queue{      //队列
	int a[]=new int[1000];
	int F=0;
	int L=0;
	void come(int num){
		if(L>=999)
			System.out.println("队满");
		a[L]=num;
		L++;	
	}
	void out(){
		if(F>L)
			System.out.println("队空");
		F++;
	}
	int isexit() {
		if(L>F)
			return 1;
		else
			return 0;
	}
}

