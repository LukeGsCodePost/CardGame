
import javafx.application.Application;

//Imports for stage and positioning.
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;


//Imports for components in this application.
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;

//progbar and radio button imports.
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
//Imports for images.
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



//Imports for layout.
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



public class HiLowJavafx extends Application
{   //class level
	

    //Declare labels
	Label lblFirst, lblSecond, lblNext;
	
	//Declare Radio Buttons
	
	//radio button 1 
	RadioButton rb1 = new RadioButton();
	
	// radio button 2
	RadioButton rb2 = new RadioButton();
	
	Button btnFirst, btnSecond;
	
	//Declare controls at class scope. Including images, label, progar and menu
	Label lblStatus;	
	MenuBar mBar;	
	Image imgRight2;
	ImageView imgViewRight;
	ProgressBar progBar;
    ProgressIndicator progIndicator;
	private Label progLabel;
	
	//int track is used to keep track of the previous card's rank
    public int track;
    
    // A deck of cards to be used in the game.
    DeckOfCards deck;     
    
    
    String message;  
    
    //    left card
    Card card1;   
    
    //    right card
    Card card2;   
    
    //label that can be used to set text
    final Label label = new Label();
    
    //keep track of how many high and low successes were made by the user
    int winTrack=0;
    
   
	public HiLowJavafx() {
		// empty constructor
	}

	@Override
	public void init(){
		
		
		//Instantiate components.
		lblFirst = new Label("First Card Dealt:");
		lblSecond = new Label("Second Card dealt:");
		lblNext = new Label("Next Card Will Be:");
				
		
		mBar = new MenuBar();
		
		//File menu
				Menu mnuFile = new Menu("File");
		
		
		//add new game to file menu
				MenuItem newGame = new MenuItem("New Game");
				mnuFile.getItems().add(newGame);
				
		//add shuffle to file menu
				MenuItem shuffle = new MenuItem("Shuffle");	
				mnuFile.getItems().add(shuffle);
				
		//add exit to file menu
				MenuItem exit = new MenuItem("Exit");
				mnuFile.getItems().add(exit);
			
		//Add the menu to the menu bar.
				mBar.getMenus().add(mnuFile);
				
		
		//Create a help menu.
				Menu mnuHelp = new Menu("Help");
				
		//Add menu items to the help menu.
				MenuItem aboutItem = new MenuItem("About");
				mnuHelp.getItems().add(aboutItem);
				
				aboutItem.setOnAction(ae -> showAboutDialog());
				
		//Add the help menu to the menu bar.
				mBar.getMenus().add(mnuHelp);
				
	   //adds prog bar and indicator
				progBar = new ProgressBar(0);
				progIndicator = new ProgressIndicator(0);		
		
		
		
	   //action for new game		

	    newGame.setOnAction(ae ->  { {
	    	deck = new DeckOfCards();    //new deck is created
	    	winTrack=0;    //resets winTrack
	    	
	    	deck.shuffle();     //shuffles the new deck
	    	
	   //the following for loops are used to reset the prog bar and indicator fo when the user click new game
	    	float current_progress = 0f;     
	    	for(int i = 0; i < 10; i++)  {
	    	            current_progress += 0.00;
	    	            progBar.setProgress(current_progress);
	    	        }
	    	     
	    	for(int i = 0; i < 10; i++)  {
	    	            current_progress += 0.00;
	    	            progIndicator.setProgress(current_progress);
	    	        }
	    
	    }
	    });
		//shuffle event
		shuffle.setOnAction(ae ->  {  {
			//simply shuffles the deck
			
			deck.shuffle();
		

       return;
    }
		});
		
		//exit menu event
		exit.setOnAction(ae ->  { {
			//exits application
			javafx.application.Platform.exit();
		}
		
		});
 
			
		
		
	}//init()
	
    //show about dialog in the help menu  method
		private void showAboutDialog(){
			
			//Create a new stage and set sizes and title.
			Stage dialog = new Stage();
			dialog.setWidth(250);
			dialog.setHeight(180);
			dialog.setTitle("About");
			
			//A label for the dialog.
			Label lblAbout = new Label(" Luke Gallagher 2933229 ");
			
			//An OK button for the dialog.
			Button btnOK = new Button("OK");
			
			//Handle events (clicks) on the dialog button.
			btnOK.setOnAction(ae -> dialog.close());
			btnOK.setMinWidth(120);
			
			
			//Layout for the about dialog.
			VBox vbAbout = new VBox();
			BorderPane dlgBP = new BorderPane();
			dlgBP.setCenter(btnOK);
			
			//The button.
			BorderPane bpLbl = new BorderPane();
			bpLbl.setCenter(lblAbout);
			
			//Set the padding.
			vbAbout.setPadding(new Insets(40));
			vbAbout.setSpacing(20);
				
			
			
			//Add components.
			vbAbout.getChildren().add(bpLbl);
			vbAbout.getChildren().add(dlgBP);
			
			
			//Create a scene.
			Scene dlgScene = new Scene(vbAbout);

			//Set the scene.
			dialog.setScene(dlgScene);
			
			
			//Show the stage.
			dialog.show();		
			
			
		}//showAboutDialog()			

	
	@Override
	public void start(Stage pStage) throws Exception {
		
		//Set the title.
		pStage.setTitle("Hi-Lo Card Game");
		
		
		//Set the width and height.
		//Width and height.
		pStage.setWidth(600);
		pStage.setHeight(400);	
		
		//Instantiate components.
		lblFirst = new Label("First Card Dealt:");
		lblSecond = new Label("Second Card Dealt:");
		lblNext = new Label("Next Card Will Be:");
		progLabel= new Label("Winning progress");
		
		//first dealt card and second dealt card buttons.
		btnFirst = new Button("<- Deal First Card");
		btnSecond = new Button("Deal Second Card ->");
		
		//Manage button sizes.
		btnFirst.setMaxWidth(130);
		btnSecond.setMaxWidth(130);
		
		//rb button functionality only one can be selected at once, toggle group is created
				ToggleGroup group = new ToggleGroup();
			    RadioButton rb1 = new RadioButton("Higher");
			    rb1.setToggleGroup(group);
			    rb1.setSelected(true);
			    RadioButton rb2 = new RadioButton("Lower");
			    rb2.setToggleGroup(group);
	    
			    
		//creates the deck and shuffles it	    
			    deck = new DeckOfCards();  
			    deck.shuffle();
	
		         
		//Create a layout.
		BorderPane bpMain = new BorderPane();

		//disables second button when the first button isn't clicked
		btnSecond.setDisable(true); 
		
		//adds menu
		bpMain.setTop(mBar);
		
		//adds vbox for the center of the borderpane
		VBox pane1 = new VBox();
		
		//adds components
		pane1.getChildren().add(lblNext);
	    pane1.getChildren().add(rb1);
	    pane1.getChildren().add(rb2);
	    pane1.getChildren().add(btnFirst);
	    pane1.getChildren().add(btnSecond);
	    pane1.getChildren().add(label);
	    pane1.getChildren().add(progLabel);
	    pane1.getChildren().addAll(progBar, progIndicator);	   
	    
	    //positions and adds spacing to added components pane1
	    pane1.setAlignment(Pos.CENTER);
	    pane1.setSpacing(10);
	    
	    //adds pane 1 to borderpane with positoning
		BorderPane.setAlignment(pane1, Pos.CENTER);
	    BorderPane.setMargin(pane1, new Insets(40,12,12,15));
	    bpMain.setCenter(pane1);
								
	    //images 

       
        
  	   //adds vbox for the left of the borderpane
        VBox pane2 = new VBox();
      
        //adds components to pane2
        pane2.getChildren().add(lblFirst );
        
        //adds image to pane 2 i.e. 'file:' is used as a shortcut to access card folder
        Image img = new Image("file:cards/red_joker.png"); 
    	ImageView imgView = new ImageView(img);
        pane2.getChildren().add(imgView);
       
        //sets alignment and positoning for pane2 to borderpane
        BorderPane.setAlignment(pane2, Pos.TOP_LEFT);
	    BorderPane.setMargin(pane2, new Insets(12,12,12,12));
		bpMain.setLeft(pane2);
		
		//keeps everything in line by disabling the max button
		pStage.resizableProperty().setValue(Boolean.FALSE);
		
		
		//adds vbox for the right of the borderpane
		VBox pane3 = new VBox();
		
        //adds components and images to pane3
        Image img2 = new Image("file:cards/red_joker.png"); 
    	ImageView imgView2 = new ImageView(img2);
        pane3.getChildren().add(lblSecond);    
        pane3.getChildren().add(imgView2);
   
        BorderPane.setAlignment(pane3, Pos.TOP_RIGHT);
	    BorderPane.setMargin(pane3, new Insets(12,12,12,12));
		bpMain.setRight(pane3);
		
		//Create a scene.
		Scene s = new Scene(bpMain);
		
		//Set the scene.
		pStage.setScene(s);
		
		
		//------------------------------------------------------------------------------------
		//action event for the first card that is dealt on the left hand side
	    btnFirst.setOnAction(e ->{ {
	    	//clears old card
	    	pane2.getChildren().clear();
	    	//adds label to keep it consistent
		    pane2.getChildren().add(lblFirst);
            
	        //enables deal second card button
			btnSecond.setDisable(false); 

			//deals the 1st card from the deck i.e. deal top card
	    	   Card card1 =  deck.deal(); 
	    	   
	    	   //if the deck is empty it prints it on the console
	    	   deck.isEmpty();
	    	   
	    	   //stores the rank of the first card
			   track =card1.getRank();
	
	    	//represents the dealt card on the application with an image
	       Image img3 = new Image("file:cards/" +card1.toString(card1)+".png");
	       System.out.println("left dealt card"+ " " + card1.toString(card1));
	       ImageView imgView3 = new ImageView(img3);
	     
	       //adds image to pane2 and borderpane
	         pane2.getChildren().add(imgView3);	       
	         pane3.getChildren().clear();
	         pane3.getChildren().add(imgView2);
	         
	            BorderPane.setAlignment(pane2, Pos.TOP_LEFT);
	    	    BorderPane.setMargin(pane2, new Insets(12,12,12,12));
	    		bpMain.setLeft(pane2);
	    		btnFirst.setDisable(true); 
	        }
	    });//ends btnfirst action
	    //--------------------------------------------------------------------------------------
	    //--------------------------------------------------------------------------------------
	  //action event for the second card that is dealt on the right hand side

	    btnSecond.setOnAction(e ->{ { 
	    	//clears old card
	    	pane3.getChildren().clear();
			 pane3.getChildren().add(lblSecond);

            //enables btn first
	    	btnFirst.setDisable(false); 

	        //deals second card
	    	Card card2 = deck.deal(); 
	    	
	    	 //if the deck is empty it prints it on the console
	    	deck.isEmpty();
	    	
	    	//creates path to card image and adds it to the app
	     	Image img3 = new Image("file:cards/" +card2.toString(card2)+".png");
	         System.out.println("right dealt card" + " "+ card2.toString(card2));
	         ImageView imgView5 = new ImageView(img3);
	         pane3.getChildren().add(imgView5);
	         BorderPane.setAlignment(pane3, Pos.TOP_RIGHT);
	 	     BorderPane.setMargin(pane3, new Insets(12,12,12,12));
	 		 bpMain.setRight(pane3);
	         
	 		 //disables second button
	 		btnSecond.setDisable(true); 
 
	 		
	 		//prog value is created for the progress bar
	 		double progValue = progBar.progressProperty().get();
	    		
	 		//gets rank of right hand card
		 	int rank2 = card2.getRank();
		 	
		 	// during the debug phase of the project if statements were decided to be used instead of the RankIsMore and less methods  
		 	//this was decided because exception handling and catching was easier along with a consistent success of the game working
		 	
		  	 	 if  (rb1.isSelected()  && track > rank2){
		  	 	//	 card2.RankI
                	label.setText("Failed!! The next card was lower");
                	
		  	 	 } 
		  	 	 if  (rb1.isSelected() &&  track < rank2){			  	 
			  	    label.setText("Success!! The next card was higher");
			  	  progValue = progValue + 0.25;
			  	     winTrack++;

		  	 	 }
		  	 	if  (rb2.isSelected()  && track > rank2){
			  	 	label.setText("Success!! The next card was lower");
			  	 	progValue = progValue + 0.25;
			  	 	winTrack++;
			  	 	 }
			  	 if  (rb2.isSelected() &&  track < rank2){
				  	label.setText("Failed!! The next card was higher");
			  	 	 }
			  	 if(winTrack==5){
			  		label.setText("Success 5 wins. You win the game");
			  		winTrack=0;
			  		
			    	        }  	 

			  	 else if  (rb2.isSelected() &&  track == rank2){
			  		label.setText("These cards are equal try again");
			  	 }
				
					if(progValue >= 0.7){
						//Set a style. Show a green progress bar.
						progBar.setStyle("-fx-accent: red;");
						progIndicator.setStyle("-fx-accent: red;");
					}//if
					else
					{
						//Set a style. Show a green progress bar.
						progBar.setStyle("-fx-accent: green;");
						progIndicator.setStyle("-fx-accent: green;");
					}//else
					
					//Don't let the progress bar or indicator go off scale.
					if(progValue < 0.95){
					//Set the new (increased) progress.			
					progBar.setProgress(progValue);
					
					//Set the progress indicator.
					progIndicator.setProgress(progValue);
					}
								
					else{
						progValue = 1;
						progBar.setProgress(progValue);
						progIndicator.setProgress(progValue);
						
					}//else
	    }
										  });
				
		
		//Show the stage.
		pStage.show();
		
		

	}//start()


	public static void main(String[] args) {
		//Launch the application.
		launch();
		}//main()

}//class