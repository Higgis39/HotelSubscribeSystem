package presentation.view;

import java.util.ArrayList;

import businessLogic.hotelbl.SearchController;
import businessLogicService.hotelBLService.SearchService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;
import presentation.controller.FrameController;
import vo.FrameToFrameVO;
import vo.HotelVO;

public class SearchResultFrameController {
	@FXML
	private ComboBox<String> combobox1;
	@FXML
	private ComboBox<String> combobox2;
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
	private TableColumn<HotelVO,Number> minprice;
	@FXML
	private TableColumn<HotelVO,Boolean> view;
	@FXML
	private TableColumn<HotelVO,Boolean> link;
	@FXML
	private TableColumn<HotelVO,Boolean> IsIn;

	private SearchResultFrame searchresultframe;
	
	FrameController viewcontrol = new FrameController();
	
	SearchService service = new SearchController();
	
	@FXML
	/**
	 * 返回按钮的监听
	 */
	private void returnAction(){
		searchresultframe.getPrimaryStage().close();
		FrameToFrameVO.getSatge().show();
	}
	
	@FXML
	/**
	 * 确定按钮的监听
	 */
	private void confirmAction(){
		String sortstyle = combobox1.getSelectionModel().getSelectedItem();
		String sortaspect = combobox2.getSelectionModel().getSelectedItem();
		if(sortstyle!=null&&sortaspect!=null){
			ArrayList<HotelVO> hotellist = service.SortHotel(FrameToFrameVO.getArrayList(), sortstyle, sortaspect);
			ObservableList<HotelVO> data = FXCollections.observableArrayList(hotellist);
			tableview.setItems(data);
			hotelname.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			address.setCellValueFactory(cellData->cellData.getValue().getAddressProperty());
			phonenumber.setCellValueFactory(cellData->cellData.getValue().getPhonenumberProperty());
			star.setCellValueFactory(cellData->cellData.getValue().getStarProperty());
			grade.setCellValueFactory(cellData->cellData.getValue().getGradeProperty());
			
			IsIn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO,Boolean>,ObservableValue<Boolean>>(){
				@Override
				public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> param){   
					return param.getValue().getIsInProperty();
				}   
			});
			
			IsIn.setCellFactory( CheckBoxTableCell.forTableColumn(IsIn));
			
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
	        
	        FrameToFrameVO.setArrayList(hotellist);
		}
	}
	
	@FXML
	/**
	 * 初始化
	 */
	private void initialize(){
		combobox1.getItems().addAll("按酒店星级排序","按酒店评分排序","按房间最低价格排序");
		combobox2.getItems().addAll("从大到小","从小到大");
		
		ArrayList<HotelVO> hotel = FrameToFrameVO.getArrayList();
		if(hotel!=null){
			ObservableList<HotelVO> data = FXCollections.observableArrayList(hotel);
			tableview.setItems(data);
			hotelname.setCellValueFactory(cellData->cellData.getValue().getNameProperty());
			address.setCellValueFactory(cellData->cellData.getValue().getAddressProperty());
			phonenumber.setCellValueFactory(cellData->cellData.getValue().getPhonenumberProperty());
			star.setCellValueFactory(cellData->cellData.getValue().getStarProperty());
			grade.setCellValueFactory(cellData->cellData.getValue().getGradeProperty());
			
			IsIn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO,Boolean>,ObservableValue<Boolean>>(){
				@Override
				public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> param){   
					return param.getValue().getIsInProperty();
				}   
			});
			
			IsIn.setCellFactory( CheckBoxTableCell.forTableColumn(IsIn));
			
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
		FrameToFrameVO.setStage2(searchresultframe.getPrimaryStage());
	}
}
