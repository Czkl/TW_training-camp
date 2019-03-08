function bestCharge(selectedItems) {


  /*
  任务分解

    1.获取订餐信息
    2.
    3.得到最优选择，
    4.打印优惠信息
    5.打印总计。
   */

  let orderItems = getOrderItems(selectedItems);
  let result = printOrderInfo(orderItems);
  result += printBestDiscount(orderItems);
  console.log(result);
  return result;

}

// 获取订餐信息对象数组
function getOrderItems(selectedItems){
  let result = new Array();
  let items = loadAllItems();
  for(let item of selectedItems){
    var itemInfo = item.split("x");
    let itemId = itemInfo[0].trim();
    let itemNum = itemInfo[1].trim();
    let obj = items.find((element => (element.id == itemId)));
    obj.num = itemNum;
    result.push(obj);
  }
  return result;
}


function fullReduction(totoalCost) {
  return totoalCost >= 30 ? totoalCost - 6 : totoalCost;
}


// 是否有指定半价菜品
function getDiscountItems(orderItems) {

  let discountItems = new Array(); // 订餐里包含的指定半价菜品

  let allDiscountItems = loadPromotions()[1].items;

  for (let i = 0;i< allDiscountItems.length;i++){

    let item = orderItems.find(elment => (elment.id == allDiscountItems[i]))

    if (item !== undefined) {
      discountItems.push(item);
    }

  }
  return discountItems;
}

// 第二种 ，指定商品半价
function halfPriceOfDiscountCost(discountItems) {

  let discountCost = 0;
  for (let item of discountItems) {
    discountCost += (item.price  * item.num) / 2;
  }
  return discountCost;
}

// 不优惠总价格
function getTotalCost(orderItems) {
  let totalCost = 0;
  for (let item of orderItems){
    totalCost += item.price * item.num;
  }
  return totalCost;
}

function printBestDiscount(orderItems) {

  let result = "-----------------------------------\n";
  let totalCost = getTotalCost(orderItems); // 总价
  let cost = 0;
  // 该订餐中哪些是可以享受半价
  let discountItems = getDiscountItems(orderItems);

  // 指定半价 省了多少
  let discountCost = halfPriceOfDiscountCost(discountItems);

  // 是否可以享受优惠

  if (totalCost > 30 || discountCost > 0) {
    result += "使用优惠: \n";
    if (discountCost <= 6) {
      result += "满30减6元，省6元\n";
      totalCost = totalCost - 6;
    }
    else {
      result += "指定菜品半价(";
      for (let item of discountItems) {
        result += item.name + "x" + item.num + "，";
      }
      result = result.substr(0, result.length - 1);
      result += ")，省" + discountCost +"元\n";
      totalCost = totalCost - discountCost;
    }
    result += "-----------------------------------\n";
  }
  result += "总计：" + totalCost+"元\n===================================\n";

  return result;
}

// 打印订餐信息
function printOrderInfo(orderItems) {

  let result = "\n============= 订餐明细 ============= \n";
  for (let item of orderItems){

    result += item.name + " x " + item.num + " = " + item.price * item.num + "元\n";
  }

  return result;
}

