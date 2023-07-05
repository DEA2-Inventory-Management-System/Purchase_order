package com.example.purchase.order;

import com.example.purchase.order.dto.RequestDto;
import com.zaxxer.hikari.util.FastList;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public
class RequestService{
    private static final ModelMapper mapper = null;

    @Autowired
    RequestRepository requestRepository;

    public void saveRequest(RequestDto requestDto) {
        List<Request> reqList = new ArrayList<>();
        requestDto.getItems().forEach(x -> {
            x.getItem().forEach(y->{

                Request reqObj = new Request();
                reqObj.setDate(requestDto.getDate());
                reqObj.setPo(requestDto.getPo());
                reqObj.setItemName(x.getItemName());
                reqObj.setUnitPrice(x.getUnitPrice());
                reqObj.setItemColor(y.getItemColor());
                reqObj.setQuantity(y.getQuantity());
                reqList.add(reqObj);
            });
        });
        requestRepository.saveAll(reqList);
    }

    public List<Request> getRequests(String itemName, String itemColor, String po, String date) {
        List<Request> poRequests = new ArrayList<Request>();
        requestRepository.findAll(Specification.where(itemNameEquals(itemName)).and(itemColorEquals(itemColor)).and(poEquals(po)).and(dateEquals(date))).forEach(updated -> poRequests.add((Request) updated));
        return poRequests;
    }

    private Specification<Request> itemCodeEquals(final String itemCode) {

        return StringUtils.isEmpty(itemCode) ? null : (root, query, builder) -> builder.equal(root.get("itemCode"), itemCode);
    }

    private Specification<Request> itemNameEquals(final String itemName) {

        return StringUtils.isEmpty(itemName) ? null : (root, query, builder) -> builder.equal(root.get("itemName"), itemName);
    }

    private Specification<Request> itemColorEquals(final String itemColor) {

        return StringUtils.isEmpty(itemColor) ? null : (root, query, builder) -> builder.equal(root.get("itemColor"), itemColor);
    }

    private Specification<Request> poEquals(final String po) {

        return StringUtils.isEmpty(po) ? null : (root, query, builder) -> builder.equal(root.get("po"), po);
    }

    private Specification<Request> dateEquals(final String date) {

        return StringUtils.isEmpty(date) ? null : (root, query, builder) -> builder.equal(root.get("date"), date);
    }

}