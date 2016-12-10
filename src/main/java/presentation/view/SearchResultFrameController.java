package presentation.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.controller.ViewController;
import vo.HotelVO;

public class SearchResultFrameController {
	@FXML
	private TableView<HotelVO> tableview;
	@FXML
	private TableColumn<HotelVO,String> hotelname;
	@FXML
	private TableColumn<HotelVO,String> address;
	@FXML
	private TableColumn<HotelVO,String> phonenumber;
	@FXML
	private TableColumn<HotelVO,Number> star;
	@FXML
	private TableColumn<HotelVO,Number> grade;

	private SearchResultFrame searchresultframe;
	
	ViewController viewcontrol = new ViewController();
	
	@FXML
	private void returnAction(){
		viewcontrol.openUserMainFrame();
		searchresultframe.getPrimaryStage().close();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		ArrayList<HotelVO> hotel = new ArrayList<HotelVO>();
		ObservableList<HotelVO> data = FXCollections.observableArrayList(hotel);
		tableview.setItems(data);
		hotelname.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
		address.setCellValueFactory(cellData->cellData.getValue().getAddressProperty());
		phonenumber.setCellValueFactory(cellData->cellData.getValue().getPhonenumberProperty());
		star.setCellValueFactory(cellData->cellData.getValue().getStarProperty());
		grade.setCellValueFactory(cellData->cellData.getValue().getGradeProperty());
	}
	
	public void setSearchResultFrame(SearchResultFrame searchresultframe){
		this.searchresultframe = searchresultframe;
	}
}
