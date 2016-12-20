package presentation.view;

import java.util.ArrayList;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import presentation.controller.FrameController;
import vo.ArrayListVO;
import vo.HotelVO;
import vo.StageVO;

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
	@FXML
	private TableColumn<HotelVO,Boolean> view;
	@FXML
	private TableColumn<HotelVO,Boolean> link;

	private SearchResultFrame searchresultframe;
	
	FrameController viewcontrol = new FrameController();
	
	@FXML
	private void returnAction(){
		searchresultframe.getPrimaryStage().close();
		StageVO.getSatge().show();
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		ArrayList<HotelVO> hotel = ArrayListVO.getArrayList();
		if(hotel!=null){
			ObservableList<HotelVO> data = FXCollections.observableArrayList(hotel);
			tableview.setItems(data);
			hotelname.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			address.setCellValueFactory(cellData->cellData.getValue().getAddressProperty());
			phonenumber.setCellValueFactory(cellData->cellData.getValue().getPhonenumberProperty());
			star.setCellValueFactory(cellData->cellData.getValue().getStarProperty());
			grade.setCellValueFactory(cellData->cellData.getValue().getGradeProperty());
			
			view.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO, Boolean>, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> p) {
	                return new SimpleBooleanProperty(p.getValue()!=null);
	            }
	        });

	        view.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() {
	            @Override
	            public TableCell<HotelVO, Boolean> call(TableColumn<HotelVO, Boolean> p) {
	                return new ButtonCell5();
	            }
	        });
			
			link.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO, Boolean>, ObservableValue<Boolean>>() {
	            @Override
	            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> p) {
	                return new SimpleBooleanProperty(p.getValue()!=null);
	            }
	        });

	        link.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() {
	            @Override
	            public TableCell<HotelVO, Boolean> call(TableColumn<HotelVO, Boolean> p) {
	                return new ButtonCell();
	            }
	        });
		}
	}
	
	public void setSearchResultFrame(SearchResultFrame searchresultframe){
		this.searchresultframe = searchresultframe;
		StageVO.setStage2(searchresultframe.getPrimaryStage());
	}
}
