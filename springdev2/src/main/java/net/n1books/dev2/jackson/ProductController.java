package net.n1books.dev2.jackson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

	@RequestMapping(value="getProduct",
			headers="Accept=application/json;charset=UTF-8",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public Product getProduct() {
		return new Product("사과", 300, 3, "빨개요");
	}

	@RequestMapping(value="getProductList",
			headers="Accept=application/json;charset=UTF-8",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public List<Product> getProductList() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product("SevenKnights", 200000, 1, "박민규"));
		list.add(new Product("ClashRoyale", 200000, 2, "유주우"));
		list.add(new Product("GrandChase", 200000, 3, "홍종우"));
		list.add(new Product("RagnarokM", 200000, 4, "누군가"));
		return list;
	}
	
}
