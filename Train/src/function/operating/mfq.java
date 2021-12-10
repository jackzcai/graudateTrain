/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package function.operating;


import javax.swing.*;

/**
 *
 * @author admin
 */
public class mfq{
    int input;
    PCB[] pcb; 
void input(){
pcb=new PCB[input];    
}
void write(int i,int a,int b,int c){
pcb[i]=new PCB(a,b,c);
}
PCB[] now(int k){
int i,j;
PCB[] jj=new PCB[k];
jj=pcb;
    PCB t=new PCB();
		for(i=0;i<k-1;i++){    //排列，先到达的排在前面
			for(j=0;j<k-1-i;j++){
				if(jj[j].AT>jj[j+1].AT)
				{
					t=jj[j];jj[j]=jj[j+1];jj[j+1]=t;
				}
			}
		}         
    return jj;            
}
PCB[] show(){
PCB[] jj=pcb;
return jj;
}
void runway(JTextArea one,JTextArea two,JTextField three){
int i,j;int clock=0;	
		Queue Wait=new Queue();     //等待队列
		Queue Ready=new Queue();
                Queue r2=new Queue();//就绪队列
		int CPUTIME=3,runtime=0,cpu2=5,cpu3=8;       //设置时间片为3
		PCB t=new PCB();
		for(i=0;i<input-1;i++){    //排列，先到达的排在前面
			for(j=0;j<input-1-i;j++){
				if(pcb[j].AT>pcb[j+1].AT)
				{
					t=pcb[j];pcb[j]=pcb[j+1];pcb[j+1]=t;
				}
			}
		}
		int nowtime=pcb[0].AT;  //现在的时间为第一个进程到达的时间
		for(i=0;i<input;i++){
			         //如果现在的时间大于到达时间就进入就绪队列
				Ready.come(i);                //否则进入等待队列
				pcb[i].State='W';
			
	
		}
		while( Ready.isexit()==1 ) {
			while(Ready.isexit()==1) {
                            int kg=0;kg=Ready.a[Ready.F];
                            if(pcb[Ready.a[Ready.F]].RT>=CPUTIME){ 
				pcb[Ready.a[Ready.F]].RT=pcb[Ready.a[Ready.F]].RT-CPUTIME;
                             runtime=CPUTIME;}
                            else{runtime=pcb[Ready.a[Ready.F]].RT;
                                pcb[Ready.a[Ready.F]].RT=0;
                            
                            }

				pcb[Ready.a[Ready.F]].CPUT++;                              //已占用CPU时间+1
				pcb[Ready.a[Ready.F]].State='R';                           //状态先置为运行
				if(pcb[Ready.a[Ready.F]].RT>0) {                           //如果进程需要的时间大于0，则进入等待队列
					Wait.come(Ready.a[Ready.F]);
                                       //否则把进程需要的时间置为0、把状态置为结束					
				}
				else {                                                   
					pcb[Ready.a[Ready.F]].RT=0;
					pcb[Ready.a[Ready.F]].State='F';
					Ready.out();
				}
				one.append("现在的时间为："+nowtime+"\n");
				one.append("进程名  到达时间  需要运行时间  已占用CPU时间  进程状态"+"\n");  //输出进程名、到达时间、需要运行时间、 已占用CPU时间、进程状态
				for(i=0;i<input;i++){	
					one.append("    "+pcb[i].name+"               ");
					one.append(pcb[i].AT+"              ");
					one.append(pcb[i].RT+"                           ");
					one.append(pcb[i].CPUT+"                        ");
					one.append(String.valueOf(pcb[i].State)+"\n");
				}
				if(pcb[Ready.a[Ready.F]].State=='R'){
					pcb[Ready.a[Ready.F]].State='W';
					Ready.out();
				}				
				nowtime=nowtime+runtime;                      //现在的时间为一个时间片后

                                for(int kk=0;kk<runtime;kk++){
                                    int hh=kg;
                                   clock++;
                                    for(int sb=0;sb<=hh;sb++){
                                   two.append("      ");
                                    }
                                    three.setText(String.valueOf(clock));
                                    two.append("|");
                                    two.append("\n");
                                 
                                
                                    try{Thread.sleep(1000);}
                                    catch(Exception e){}
                              
                                }
                            
                                
                               
			}
			one.append("现在的时间为："+nowtime+"\n");        //现在的时间为一个时间片后
		}
                		while( Wait.isexit()==1 ) {
			while(Wait.isexit()==1) {
                            int kg=0;kg=Wait.a[Wait.F];
                            if(pcb[Wait.a[Wait.F]].RT>=cpu2){ 
				pcb[Wait.a[Wait.F]].RT=pcb[Wait.a[Wait.F]].RT-cpu2;
                             runtime=cpu2;}
                            else{runtime=pcb[Wait.a[Wait.F]].RT;
                                pcb[Wait.a[Wait.F]].RT=0;
                            
                            }

				pcb[Wait.a[Wait.F]].CPUT++;                              //已占用CPU时间+1
				pcb[Wait.a[Wait.F]].State='R';                           //状态先置为运行
				if(pcb[Wait.a[Wait.F]].RT>0) {                           //如果进程需要的时间大于0，则进入等待队列
					r2.come(Wait.a[Wait.F]);
                                       //否则把进程需要的时间置为0、把状态置为结束					
				}
				else {                                                   
					pcb[Wait.a[Wait.F]].RT=0;
					pcb[Wait.a[Wait.F]].State='F';
					Wait.out();
				}
				one.append("现在的时间为："+nowtime+"\n");
				one.append("进程名  到达时间  需要运行时间  已占用CPU时间  进程状态"+"\n");  //输出进程名、到达时间、需要运行时间、 已占用CPU时间、进程状态
				for(i=0;i<input;i++){	
					one.append("    "+pcb[i].name+"               ");
					one.append(pcb[i].AT+"              ");
					one.append(pcb[i].RT+"                           ");
					one.append(pcb[i].CPUT+"                        ");
					one.append(String.valueOf(pcb[i].State)+"\n");
				}
				if(pcb[Wait.a[Wait.F]].State=='R'){
					pcb[Wait.a[Wait.F]].State='W';
					Wait.out();
				}				
				nowtime=nowtime+runtime;                      //现在的时间为一个时间片后
                                
                                for(int kk=0;kk<runtime;kk++){
                                    int hh=kg;
                                    clock++;
                                    for(int sb=0;sb<=hh;sb++){
                                   two.append("      ");
                                    }
                                    
                                    two.append("|");
                                    two.append("\n");
                                    three.setText(String.valueOf(clock));
                                    
                                    try{Thread.sleep(1000);}
                                    catch(Exception e){}
                              
                                }
                            
                                
                               
			}
			one.append("现在的时间为："+nowtime+"\n");        //现在的时间为一个时间片后
		}
              while( r2.isexit()==1 ) {
			while(r2.isexit()==1) {
                            int kg=0;kg=r2.a[r2.F];
                            if(pcb[r2.a[r2.F]].RT>=cpu3){ 
				pcb[r2.a[r2.F]].RT=pcb[r2.a[r2.F]].RT-cpu3;
                             runtime=cpu3;}
                            else{runtime=pcb[r2.a[r2.F]].RT;
                                pcb[r2.a[r2.F]].RT=0;
                            
                            }

				pcb[r2.a[r2.F]].CPUT++;                              //已占用CPU时间+1
				pcb[r2.a[r2.F]].State='R';                           //状态先置为运行
				if(pcb[r2.a[r2.F]].RT>0) {                           //如果进程需要的时间大于0，则进入等待队列
					r2.come(r2.a[r2.F]);
                                       //否则把进程需要的时间置为0、把状态置为结束					
				}
				else {                                                   
					pcb[r2.a[r2.F]].RT=0;
					pcb[r2.a[r2.F]].State='F';
					r2.out();
				}
				one.append("现在的时间为："+nowtime+"\n");
				one.append("进程名  到达时间  需要运行时间  已占用CPU时间  进程状态"+"\n");  //输出进程名、到达时间、需要运行时间、 已占用CPU时间、进程状态
				for(i=0;i<input;i++){	
					one.append("    "+pcb[i].name+"               ");
					one.append(pcb[i].AT+"              ");
					one.append(pcb[i].RT+"                           ");
					one.append(pcb[i].CPUT+"                        ");
					one.append(String.valueOf(pcb[i].State)+"\n");
				}
				if(pcb[r2.a[r2.F]].State=='R'){
					pcb[r2.a[r2.F]].State='W';
					r2.out();
				}				
				nowtime=nowtime+runtime;                      //现在的时间为一个时间片后

                                for(int kk=0;kk<runtime;kk++){
                                    int hh=kg;
                                   clock++;
                                    for(int sb=0;sb<=hh;sb++){
                                   two.append("      ");
                                    }
                                    three.setText(String.valueOf(clock));
                                    two.append("|");
                                    two.append("\n");
                                 
                                
                                    try{Thread.sleep(1000);}
                                    catch(Exception e){}
                              
                                }
                            
                                
                               
			}
			one.append("现在的时间为："+nowtime+"\n");        //现在的时间为一个时间片后
		}
}
   
}
