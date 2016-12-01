package dataService;

import java.sql.SQLException;
import java.util.List;

import po.WebPromotionPO;

public interface WebPromotionDataService {

	public boolean insert(WebPromotionPO wp);
	public boolean update(WebPromotionPO wp);
	public void delete(String name);
	public List<WebPromotionPO> find(String name) throws SQLException;
}
