/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author SHAHBAZ HUSSAIN
 */
public class GraphUnitour extends javax.swing.JFrame {
        
                static final int n=26;
        int parent[];           //Parent array for marking parent for every vertex for minimum path
	String classs;
	int index;
	int distance[];
        String direction[];
	GraphUnitour adj_class[];

	//static  HashMap <Integer,String> hashMap = new HashMap <Integer,String>(); 

	public GraphUnitour(int n,String c)     //Constructor
	{
            initComponents();
		classs=c;
      direction=new String[n];          
      distance=new int[n];
      adj_class=new GraphUnitour[n];
	}

	public void add(int i, int indexOfAdjClass, int d,String dir)
	{
	  index=i;
	  adj_class[indexOfAdjClass] = new GraphUnitour(n,"");
	  distance[indexOfAdjClass]=d;
          direction[indexOfAdjClass]=dir;
	}

    public int min(int dist[], Boolean set[])
    {
    	int mini=Integer.MAX_VALUE;   //Minimum initially is Infinite
    	int min_index=-1;
    	for(int i=0;i<n;i++)
    	{
	  if (set[i] == false && dist[i] < mini)    //Find the minimum if that index is not a labelled node and distance is less than minimum
    	  {
            mini=dist[i];
            min_index=i;
          }
    	}
    	return min_index;
    }

    public String getClasss()
    {
    	return classs;
    }

    public int getDistance(int k)
    { 
    	return distance[k];
    }
    
    public String getDir(GraphUnitour t[],int s,int d)
    {
        return t[s].direction[d];
    }
            


 public void displayPath(GraphUnitour t[],int s, int d)
    {
        //jTextArea2.setText("Hello");
    	String temp_array[]=new String[n];
        String dir[]=new String[n];
        //String tempClass="";
        //jTextArea2.setText("");
    	int k=0;
        int l=0;
    	int i;
    	int temp=d;
        temp_array[k++]=t[d].getClasss();
        jTextArea1.append("\n");
        //dir[l++]=getDir(t,parent[d],d);
      
    	for(i=0;i<n;i++)
    	{
          if(parent[temp]!=-1)
          {
          	//System.out.print(a[temp]+1);
          	temp_array[k++]=t[parent[temp]].getClasss();  //Parent of Destination is stored in temp_array, we've added +1 so that it shows the index '0' as V1 or in general index i as vertex V(i+1) for our convenience
                dir[l++]=getDir(t,parent[temp],temp);
          	temp=parent[temp];               //temp is updated as destination (temp) now becomes the index stored at previous temp position of parent array
          	if(temp==s)                //if the index becomes source then break
            break;
          	//System.out.print(" -->");
          }

    	}
        if(k>1)
        {
    	 for(i=k-1;i>=0;i--)       //Display the temp_array in reverse order to display the path from source to destination
    	 {
    		if(i!=0)
                {
    		    //System.out.print(temp_array[i]+" -->");
                    jTextArea1.append(temp_array[i]+" -->");   //So that '-->' is not displayed for last element i.e source
                }
                else
                {
    	    	   //System.out.print(temp_array[i]);
                   jTextArea1.append(temp_array[i]+"\n\n");
                }
         }
         
         for(i=l-1;i>=0;i--)
         {
             jTextArea1.append(dir[i]);
         }
        }
    	if(k==1)
    		jTextArea1.setText("Sorry! Source and Destination is Same\n");
    
    }
  
   public int shortestPath(GraphUnitour t[],String src, String dest,int avo)
    {
      int s=0,d=0,i,j;
      int u=-1;
      int dist[]=new int[n];              //This array records the minimum distances from a vertex to all other vertex
      Boolean set[] = new Boolean[n];    //This array Marks true for Verices which are made permanent Labelled nodes
      
     if(avo==-1)
     {
       parent=new int[n];   
       for(i=0;i<n;i++)
       {
      	if(t[i].getClasss().equalsIgnoreCase(src))
        s=i;
       }

       for(i=0;i<n;i++)
       {
      	if(t[i].getClasss().equalsIgnoreCase(dest))
        d=i;
       }


       for(i=0;i<n;i++)
       {
        dist[i] = Integer.MAX_VALUE;     //Set all distances to infinite initially
      	set[i]=false;                    //No vertices are marked labelled node yet
      	parent[i]=-1;                    //Initialize parent array by -1 as array index starts from 0
       }
     
       dist[s]=0;                         //Distance from source to source is 0
      //parent[s]=s;
      
         
       if(handicap.equalsIgnoreCase("yes"))
       {
        for(j=0;j<n-1;j++)            //To calculate from source to all n-1 vertices
        {
         u= this.min(dist,set);    //Calculate index of vertex having Minimum distance from labelled node
         if(u==-1)
         {
               jTextArea1.setText("Sorry! There is no Path for your request\n");
               return -1;
         }
         set[u]=true;                    //Set that index as labelled node
         
         if(u==d)
             break;
         
         for(int v=0;v<n;v++)
         {
             /* Update dist[v] only if is not a labelled node set[v] should be false, there is an edge from u to v, and total weight of
              path from source node 's' to v through u is smaller than current value of dist[v] */
        	if(!set[v] && t[u].getDistance(v)!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+t[u].getDistance(v))<dist[v])
         	{
                        if(u>=15 && (v==12 || v==13))
                        {
                            continue;
                        }
         		dist[v]=dist[u]+t[u].getDistance(v);
         		parent[v]=u;   //Update the parent...the parent of vertex at index v is index u
         	}
         }
        }
       }
        else
        {
         for(j=0;j<n-1;j++)            //To calculate from source to all n-1 vertices
          {
           u= this.min(dist,set);       //Calculate index of vertex having Minimum distance from labelled node 
           set[u]=true;                 //Set that index as labelled node
           if(u==d)
               break;
        
           for(int v=0;v<n;v++)
           {
             /* Update dist[v] only if is not a labelled node set[v] should be false, there is an edge from u to v, and total weight of
              path from source node 's' to v through u is smaller than current value of dist[v] */
         	if(v!=24 && !set[v] && t[u].getDistance(v)!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+t[u].getDistance(v))<dist[v])
         	{
         		dist[v]=dist[u]+t[u].getDistance(v);
         		parent[v]=u;   //Update the parent...the parent of vertex at index v is index u
         	}
           }   
         }
        }
      }
      
      else
      {
         parent=new int[n];   
        
         for(i=0;i<n;i++)
         {
      	   if(t[i].getClasss().equalsIgnoreCase(src))
           s=i;
         }

         for(i=0;i<n;i++)
         {
      	   if(t[i].getClasss().equalsIgnoreCase(dest))
           d=i;
         }


         for(i=0;i<n;i++)
         {
          dist[i] = Integer.MAX_VALUE;     //Set all distances to infinite initially
      	  set[i]=false;                    //No vertices are marked labelled node yet
       	  parent[i]=-1;                    //Initialize parent array by -1 as array index starts from 0
         }
          dist[s]=0;                         //Distance from source to source is 0
         // jTextArea1.setText(""+s+"\n\n");
          //parent[s]=s;
      
         
         if(handicap.equalsIgnoreCase("Yes"))
         {
           for(j=0;j<n-1;j++)            //To calculate from source to all n-1 vertices
           {
           u= this.min(dist,set);    //Calculate index of vertex having Minimum distance from labelled node 
           if(u==-1)
           {
               jTextArea1.setText("Sorry! There is no Path for your request\n");
               return -1;
           }
           set[u]=true;                    //Set that index as labelled node
           
           if(u==d)
               break;
               
           try
           {
            for(int v=0;v<n;v++)
            {
          
             /* Update dist[v] only if is not a labelled node set[v] should be false, there is an edge from u to v, and total weight of
              path from source node 's' to v through u is smaller than current value of dist[v] */
         	if(!set[v] && v!=avo && t[u].getDistance(v)!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+t[u].getDistance(v))<dist[v])
                {
                    if(!(s==25 && d==24))
                    if(u>=15 && (v==12 || v==13 || v==24))
                        {
                            continue;
                        }
                    dist[v]=dist[u]+t[u].getDistance(v);
                    parent[v]=u;   //Update the parent...the parent of vertex at index v is index u
                    if(v==d)
                            break;
                }
             
           }
           }
           catch(ArrayIndexOutOfBoundsException e)
           {
            System.out.println("Sorry! There is No path for your Request\n");   
           }
            }
         }
         else
         {
           for(j=0;j<n-3;j++)            //To calculate from source to all n-1 vertices
          {
           u= this.min(dist,set);       //Calculate index of vertex having Minimum distance from labelled node
          // System.out.println(u+" ");
           //jTextArea1.append(""+u+"\n");
           if(u==-1)
           {
               jTextArea1.setText("Sorry! There is no Path for your request\n");
               return -1;
           }
           set[u]=true;                 //Set that index as labelled node
           if(u==d)
               break;
           try
           {
            for(int v=0;v<n;v++)
            {
          
             /* Update dist[v] only if is not a labelled node set[v] should be false, there is an edge from u to v, and total weight of
              path from source node 's' to v through u is smaller than current value of dist[v] */
         	if(!set[v] && (v!=avo && v!=24 && v!=25) && t[u].getDistance(v)!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+t[u].getDistance(v))<dist[v])
         	{
         		dist[v]=dist[u]+t[u].getDistance(v);
         		parent[v]=u;   //Update the parent...the parent of vertex at index v is index u
                        
         	}
             
            }
           }
           catch(ArrayIndexOutOfBoundsException e)
           {
               System.out.println("Sorry! There is No path for your Request\n");
           }
         }
      }   
      }
        
        return dist[d];        //return distance of destination from source, where 'd' is the destination
    }
  
    
    
    
    

    /**
     * Creates new form NewJFrame
     */
    int px,py;
    String handicap="";
    String avoid="";
    int avo=-1;


    /**
     * Creates new form GraphUnitour
     */
    public GraphUnitour() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 600));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(560, 120, 170, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(560, 160, 170, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 340, 710, 220);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Where Are You Currently ? ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 120, 230, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Where Do You Want To Go ? ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 160, 250, 22);

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome To ABB1 Search Utility");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 50, 420, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Would you like to avoid any Class in your path ?");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 200, 410, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Are you Handicapped ? (Yes/No)");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 240, 330, 22);

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(100, 290, 110, 30);

        jButton5.setText("View Map");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(400, 290, 120, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(560, 240, 170, 30);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(560, 200, 170, 30);

        jButton3.setText("Show Directions");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(240, 290, 120, 30);

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(560, 290, 100, 30);

        jButton7.setText("NEXT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(700, 290, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Project Frame.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(970, 600));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 970, 600);

        jButton2.setText("jButton2");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(803, 10, 30, 30);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(860, 10, 30, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.setState(GraphUnitour.ICONIFIED);
    }//GEN-LAST:event_jButton2MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        px=evt.getX();
        py=evt.getY();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        setLocation(getLocation().x+evt.getX()-px,getLocation().y+evt.getY()-py);
    }//GEN-LAST:event_formMouseDragged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         int min_path=0,s=-1,d=-1,i=0;
         jTextArea1.setText("");
	//Scanner in = new Scanner(System.in);
	GraphUnitour t[]= new GraphUnitour[n];
	t[0]=new GraphUnitour(n,"G1");
	t[1]=new GraphUnitour(n,"G2");
	t[2]=new GraphUnitour(n,"G3");
	t[3]=new GraphUnitour(n,"G4");
	t[4]=new GraphUnitour(n,"G5");
	t[5]=new GraphUnitour(n,"G6");
	t[6]=new GraphUnitour(n,"G7");
	t[7]=new GraphUnitour(n,"G8");
	t[8]=new GraphUnitour(n,"G9");
	t[9]=new GraphUnitour(n,"LT1");
	t[10]=new GraphUnitour(n,"LT2");
	t[11]=new GraphUnitour(n,"LT3");
	t[12]=new GraphUnitour(n,"Staircase 1");
	t[13]=new GraphUnitour(n,"Staircase 2");
	t[14]=new GraphUnitour(n,"Rajeev Chowk");
        
        //First Floor Starts
        
        t[15]=new GraphUnitour(n,"FF1");
        t[16]=new GraphUnitour(n,"FF2");
        t[17]=new GraphUnitour(n,"FF3");
        t[18]=new GraphUnitour(n,"FF4");
        t[19]=new GraphUnitour(n,"FF5");
        t[20]=new GraphUnitour(n,"FF6");
        t[21]=new GraphUnitour(n,"FF7");
        t[22]=new GraphUnitour(n,"FF8");
        t[23]=new GraphUnitour(n,"FF9");
        t[24]=new GraphUnitour(n,"Lift0");
        t[25]=new GraphUnitour(n,"Lift1");

       
	  /* Graph for Class */
	     t[0].add(0,1,8,"While Facing Towards G1, Move 8 Steps Rightwards\n");
	     t[0].add(0,14,25,"While Facing Towards G1, Move Left a couple of Steps and then Move Right through Gallery and finally Turn Right \n");
	     t[0].add(0,24,24,"While Facing Towards G1, Move 24 Steps Straight through the left Gallery\n");
             
	     t[1].add(1,0,8,"While Facing Towards G2, Move 8 steps Leftwards\n");
	     t[1].add(1,2,8,"While Facing Towards G2, Move 8 Steps Rightwards\n");
	     
	     t[2].add(2,1,8,"While Facing Towards G3, Move 8 steps Leftwards\n");
	     t[2].add(2,3,14,"While Facing Towards G3, Move 14 steps Rightwards\n");
	     t[2].add(2,9,35,"While Facing G3, Move Right and Move 35 Steps Straight through the Gallery\n");
	     t[2].add(2,10,35,"While Facing G3, Move Right and Move 35 Steps Straight through the Gallery\n");
	     t[2].add(2,12,28,"While Facing G3, Move 16 Steps Right through the Gallery and then Move 12 Steps Rightwards\n");
	     t[2].add(2,14,35,"While Facing G3, Move 16 Steps Right through the Gallery and then Move 19 Steps Leftwards\n");

             t[3].add(3,2,14,"While Facing Towards G4, Move 14 steps Leftwards\n");
	     t[3].add(3,4,8,"While Facing Towards G4, Move 8 Steps Rightwards\n");
	     t[3].add(3,9,35,"While Facing Towards G4, Move Left and Move 35 Steps Straight through the Gallery\n");
	     t[3].add(3,10,35,"While Facing Towards G4, Move Left and Move 35 Steps Straight through the Gallery\n");
	     t[3].add(3,12,28,"While Facing G4, Move 16 Steps Left through the Gallery and then Move 12 Steps Rightwards\n");
	     t[3].add(3,14,35,"While Facing G4, Move 16 Steps Left through the Gallery and then Move 19 Steps Leftwards\n");

	     t[4].add(4,3,8,"While Facing Towards G5, Move 8 steps Leftwards\n");
	     t[4].add(4,5,8,"While Facing Towards G5, Move 8 steps Rightwards\n");

	     t[5].add(5,4,8,"While Facing Towards G6, Move 8 steps Leftwards\n");
	     t[5].add(5,6,14,"While Facing Towards G6, Move 14 steps Rightwards\n");
	     t[5].add(5,12,32,"While Facing G6, Move 16 Steps Right through the Gallery and then Move 16 Steps Leftwards\n");
	     t[5].add(5,13,32,"While Facing G6, Move 16 Steps Right through the Gallery and then Move 16 Steps Rightwards\n");
         
             t[6].add(6,5,14,"While Facing Towards G7, Move 14 steps Leftwards\n");
	     t[6].add(6,7,8,"While Facing Towards G7, Move 8 steps Rightwards\n");
	     t[6].add(6,12,32,"While Facing G7, Move 16 Steps Left through the Gallery and then Move 16 Steps Leftwards\n");
	     t[6].add(6,13,32,"While Facing G7, Move 16 Steps Left through the Gallery and then Move 16 Steps Rightwards\n");

	     t[7].add(7,6,8,"While Facing Towards G8, Move 8 steps Leftwards\n");
	     t[7].add(7,8,8,"While Facing Towards G8, Move 8 steps Rightwards\n");

	     t[8].add(8,7,8,"While Facing Towards G9, Move 8 steps Leftwards\n");
	     t[8].add(8,11,34,"While Facing Towards G9, Move 34 steps Rightwards and then Straight Through the Gallery\n");
	     t[8].add(8,13,28,"While Facing G9, Move 16 Steps Right through the Gallery and then Move 12 Steps Leftwards\n");

	     t[9].add(9,2,35,"While Facing Towards LT1, Move 35 Steps Leftwards Through the Gallery and Take Immediate Right\n");
	     t[9].add(9,3,35,"While Facing Towards LT1, Move 35 Steps Leftwards Through the Gallery and Take Immediate Left\n");
	     t[9].add(9,10,4,"Turn Around or Face Backward\n");
	     t[9].add(9,12,24,"While Facing Towards LT1, Move 12 Steps Leftwards then Move 12 Steps Leftwards\n");
	     t[9].add(9,14,32,"While Facing Towards LT1, Move 12 Steps Leftwards then Move 20 Steps Rightwards\n");

	     t[10].add(10,2,35,"While Facing Towards LT2, Move 35 Steps Rightwards Through the Gallery and Take Immediate Right\n");
	     t[10].add(10,3,35,"While Facing Towards LT2, Move 35 Steps Rightwards Through the Gallery and Take Immediate Right\n");
	     t[10].add(10,9,4,"Turn Around or Face Backward\n");
	     t[10].add(10,12,24,"While Facing Towards LT2, Move 12 Steps Rightwards then Move 12 Steps Leftwards\n");
	     t[10].add(10,14,32,"While Facing Towards LT2, Move 12 Steps Rightwards then Move 20 Steps Leftwards\n");

	     t[11].add(11,8,34,"While Facing LT3, Move 34 Steps Leftwards through the Gallery and then Take an Immediate Right\n");
	     t[11].add(11,13,24,"While Facing LT3, Move 12 Steps Leftwards and then Move 12 Steps Rightwards\n");

	     t[12].add(12,2,35,"Move 19 Steps Straight against the direction of Staircase 1 (From the Leftside of stairs), Move 16 Steps left through the Gallery and then an Immediate Right\n");
	     t[12].add(12,3,35,"Move 19 Steps Straight against the direction of Staircase 1 (From the Lefttside of stairs), Move 16 Steps left through the Gallery and then an Immediate Left\n");
	     t[12].add(12,5,32,"Move 16 Steps Straight in the direction of Staircase 1, Move 16 Steps Rightwards and then an Immediate Right\n");
	     t[12].add(12,6,32,"Move 16 Steps Straight in the direction of Staircase 1, Move 16 Steps Rightwards and then an Immediate Left\n");
	     t[12].add(12,9,24,"Move 16 Steps Straight (From the Rightside of stairs) against the direction of Staircase 1 and then Move 8 Steps Rightwards\n");
	     t[12].add(12,10,24,"Move 16 Steps Straight (From the Rightside of stairs) against the direction of Staircase 1 and then Move 8 Steps Rightwards\n");
	     t[12].add(12,13,28,"Move 28 Steps Straight in the direction of Staircase 1\n");
	     t[12].add(12,14,40,"Move 40 Steps Straight against the direction of Staircase 1\n");
             t[12].add(12,17,24,"Climb Up The Stairs,take a Left and move 24 Steps staright Ahead\n");
             t[12].add(12,18,24,"Climb Up The Stairs,take a Left and move 24 Steps staright Ahead\n");

	     t[13].add(13,5,32,"Move 16 Steps Straight in the direction of Staircase 2, Move 16 Steps leftwards and then an Immediate Right\n");
	     t[13].add(13,6,32,"Move 16 Steps Straight in the direction of Staircase 2, Move 16 Steps leftwards and then an Immediate Left\n");
	     t[13].add(13,8,28,"Move 12 Steps Straight against the direction of Staircase 2 (From the Rightside of stairs), Move 16 Steps Rightwards and then take an Immediate Right again\n");
	     t[13].add(13,11,24,"Move 12 Steps Straight against the direction of Staircase 2 (From the Leftside of stairs) and then Move 12 Steps Leftwards\n");
	     t[13].add(13,12,28,"Move 28 Steps Straight in the direction of Staircase 2\n");
             t[13].add(13,23,24,"Climb Up The Stairs,take a Right and move 24 Steps Straight Ahead\n");

	     t[14].add(14,0,25,"Move 9 Steps towards the Direction of Gate 1 and Then Move 16 Steps Leftwards through the Gallery To take an Immediate Left\n");
	     t[14].add(14,2,35,"Move 19 Steps towards the Direction of Statue and Then Move 16 Steps Rightwards through the Gallery To take an Immediate Right\n");
	     t[14].add(14,3,35,"Move 19 Steps towards the Direction of Statue and Then Move 16 Steps Rightwards through the Gallery To take an Immediate Left\n");
	     t[14].add(14,9,32,"Move 19 Steps Straight Till 1st T point and then Move 13 Steps Leftwards\n");
	     t[14].add(14,10,32,"Move 19 Steps Straight Till 1st T point and then Move 13 Steps Leftwards\n");
	     t[14].add(14,12,40,"Move 40 Steps towards Direction Of Statue\n");
             t[14].add(14,24,20,"Move 20 Steps towards Direction of Gate 1\n");
             
             //First Floor Connection Starts
             
             
             t[15].add(15,16,10,"While Facing FF1, Move 10 Steps to your right\n");
             t[15].add(15,25,24,"While Facing Towards G1, Move 24 Steps Straight through the left Gallery\n");
             
             t[16].add(16,15,10,"While Facing FF2, Move 10 Steps to your left\n");
             t[16].add(16,17,10,"While Facing FF2, Move 10 Steps to your right\n");
             
             t[17].add(17,16,10,"While Facing FF3, Move 10 Steps to your left\n");
             t[17].add(17,18,10,"While Facing FF3, Move 10 Steps to your right\n");
             t[17].add(17,12,24,"Move a Few Steps back, take a Left, Move 24 Steps Straight Ahead, Climb downstairs\n");
             
             t[18].add(18,17,10,"While Facing FF4, Move 10 Steps to your left\n");
             t[18].add(18,19,10,"While Facing FF4, Move 10 Steps to your right\n");
             t[18].add(18,12,24,"Move a Few Steps back, take a Left, Move 24 Steps Straight Ahead, Climb downstairs\n");
             
             t[19].add(19,18,10,"While Facing FF5, Move 10 Steps to your left\n");
             t[19].add(19,20,10,"While Facing FF5, Move 10 Steps to your right\n");
             
             t[20].add(20,19,10,"While Facing FF6, Move 10 Steps to your left\n");
             t[20].add(20,21,10,"While Facing FF6, Move 10 Steps to your right\n");
             
             t[21].add(21,20,10,"While Facing FF7, Move 10 Steps to your left\n");
             t[21].add(21,22,10,"While Facing FF7, Move 10 Steps to your right\n");
             
             t[22].add(22,21,10,"While Facing FF8, Move 10 Steps to your left\n");
             t[22].add(22,23,10,"While Facing FF8, Move 10 Steps to your right\n");
             
             t[23].add(23,22,10,"While Facing FF9, Move 10 Steps to your left\n");
             t[23].add(23,13,24,"Move a few steps ahead, take a left and Move 24 Steps Straight, Climb downstairs\n");
             
             t[24].add(24,0,24,"Move 24 Steps Left , then again take left\n");
             t[24].add(24,14,20,"Turn Around and Move 20 Steps Straight\n");
             t[24].add(24,25,1,"Stand Still\n");          
             
             t[25].add(25,15,24,"Move 24 Steps Left, then again take left\n");
             t[25].add(25,24,1,"Stand Still\n");
             
          //System.out.print("Enter the source vertex : ");
         String m="";
         m=jTextField1.getText();    
         //System.out.print("Enter the destination vertex : ");
         String j="";
         j=jTextField2.getText();
         avoid=jTextField3.getText();
         handicap=jTextField4.getText();
         
         int min=0;
         
         
         if(!avoid.equals(""))
         {
           for(i=0;i<n;i++)
           {
      	    if(t[i].getClasss().equalsIgnoreCase(avoid))
            avo=i;
           } 
           if(avo==-1)
           {
               jTextArea1.setText("Please Enter Valid Detail For Path to be Avoided!\nCheck the Spelling Please\n");
             return;
           }
         }
        
         
         int lift0=-1;
         int lift1=-1;
         
         for(i=0;i<n;i++)
         {
      	  if(t[i].getClasss().equalsIgnoreCase(m))
          s=i;
         }

         for(i=0;i<n;i++)
         {
      	  if(t[i].getClasss().equalsIgnoreCase(j))
          d=i;
         }
         
         if(s==-1 || d==-1)
         {
             jTextArea1.setText("Please Enter Valid Details!\nCheck the Spelling Please\n");
             return;
         }
         
         if((s==avo) || (d==avo))
         {
             jTextArea1.setText("You can't avoid your Source or Destinaion\n");
             return;
         }
         
         //GraphUnitour obj = new GraphUnitour(n,"");
         if(m.equals("") || j.equals(""))
         {
           jTextArea1.setText("Please Enter Valid Details and Try Again!");
         }
         else if(!handicap.equalsIgnoreCase("") && !(handicap.equalsIgnoreCase("yes")|| handicap.equalsIgnoreCase("No")))
         {
             jTextArea1.setText("Please Write Yes or No in Handicap Field!\n");
             return;
         }
         else if((handicap.equalsIgnoreCase("yes") && (s<15 && d>=15) && avo!=24 && avo!=25))
         {
         
         for(i=0;i<n;i++)
         {
      	  if(t[i].getClasss().equals("Lift0"))
          lift0=i;
         }
         
         for(i=0;i<n;i++)
         {
      	  if(t[i].getClasss().equals("Lift1"))
          lift1=i;
         }
         
            min_path=shortestPath(t,m,"Lift0",avo);
            if(min_path==-1)
                return;
            displayPath(t,s,lift0);
            min=shortestPath(t,"Lift0","Lift1",avo);
            if(min==-1)
                return;
            min_path+=min;
            displayPath(t,lift0,lift1);
            min=shortestPath(t,"Lift1",j,avo);
            if(min==-1)
                return;
            min_path+=min;
            displayPath(t,lift1,d);
            jTextArea1.append("\nNo. of Steps from "+m+" to "+j+" is "+min_path);
         }
         
         else if(handicap.equalsIgnoreCase("yes") && (s>=15 && d<15) && avo!=25 && avo!=24 && s!=24 && s!=25)
         {
           for(i=0;i<n;i++)
         {
      	  if(t[i].getClasss().equals("Lift0"))
          lift0=i;
         }
         
         for(i=0;i<n;i++)
         {
      	  if(t[i].getClasss().equals("Lift1"))
          lift1=i;
         }
         
            min_path=shortestPath(t,m,"Lift1",avo);
            if(min_path==-1)
                return;
            displayPath(t,s,lift1);
            min=shortestPath(t,"Lift1","Lift0",avo);
            if(min==-1)
                return;
            min_path+=min;
            displayPath(t,lift1,lift0);
            min=shortestPath(t,"Lift0",j,avo);
            if(min==-1)
                return;
            min_path+=min;
            displayPath(t,lift0,d);
            jTextArea1.append("\nNo. of Steps from "+m+" to "+j+" is "+min_path);
         }
         else if(handicap.equalsIgnoreCase("yes") && (avo==24 || avo==25))
         {
             jTextArea1.setText("It's Mandatory to use Lift if you are specially abled\n");
         }
         else
         {
           min_path=shortestPath(t,m,j,avo);
           if(min_path<0)
           {
               jTextArea1.setText("Sorry! No Path Exists for your Request\n");
               return;
           }
           displayPath(t,s,d);
           jTextArea1.append("\nNo. of Steps from "+m+" to "+j+" is "+min_path);
         }
         
         
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        handicap="";
        avo=-1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        new MapDesign().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Aryabhatta().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
        new Last().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    
    

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphUnitour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphUnitour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphUnitour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphUnitour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        
	     
	     
       

	     
	


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphUnitour().setVisible(true);
            }
        });
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}

