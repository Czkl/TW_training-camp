
module.exports = function printInventory(inputs) {

    let orderItemsMap = getCommodityItems(inputs);
    let allItems = loadAllItems();  //
    let promotions = loadPromotions();
    let orderItemsInfo = getOrderItemsInfo(orderItemsMap,allItems);

    // 满足促销活动的商品
    let meetPMTConditionItems = promotionItems(orderItemsInfo,promotions)


    //打印订单商品信息
    let result = printOrderItemsInfo(orderItemsInfo,meetPMTConditionItems);
    // 打印促销商品信息
    result +=printPromotiontItem(meetPMTConditionItems);
    // 打印总商品价格

    let totalCost = getTotalCost(orderItemsInfo);
    let saveCost = getSaveCost(meetPMTConditionItems);
    result +="总计："+parseFloat(totalCost-saveCost).toFixed(2)+"(元)\n";
    // 打印优惠价格
    result +="节省："+parseFloat(saveCost).toFixed(2)+"(元)\n";
    result +="**********************";

    console.log(result.trim());
    return 'Hello World!';
};



// 汇总订单信息
function getCommodityItems(inputs) {
    let orderItemsMap = new Map();
    for(let item of inputs){
        if (item.length > 10) {
            let itemID = item.split("-")[0].trim();
            let itemNum = item.split('-')[1].trim();
            if (orderItemsMap.has(itemID)) {
                orderItemsMap.set(itemID, orderItemsMap.get(itemID) + itemNum);
            }
            else {
                orderItemsMap.set(itemID, itemNum);
            }
        }
        else if (orderItemsMap.has(item)) {
            orderItemsMap.set(item, orderItemsMap.get(item) + 1);
        } else {
            orderItemsMap.set(item, 1);
        }
    }
    return orderItemsMap;
}

// 根据订单信息，获得商品信息
function getOrderItemsInfo(orderItemsMap,allItems) {

    let orderItemsInfo = new Array();

    orderItemsMap.forEach(function(value, key, map){

        let item = allItems.find(element => (element.barcode == key));
        if (item != undefined) {
            item.num = value;
            orderItemsInfo.push(item);
        }
    });


    return orderItemsInfo;
}

// 打印订单信息
function printOrderItemsInfo(orderItemsInfo,meetPMTConditionItems) {
    let result = "***<没钱赚商店>购物清单***\n";

    for (let item of orderItemsInfo){
        result += "名称：" + item.name + "，数量：" + item.num +
            item.unit + "，单价：" + parseFloat(item.price).toFixed(2) + "(元)，";

        if (meetPMTConditionItems.find(element => (element.barcode == item.barcode)) != undefined) {
            result += "小计：" + parseFloat(item.price * (item.num - 1)).toFixed(2) + "(元)\n";
        }
        else {
            result +="小计：" + parseFloat(item.price * item.num).toFixed(2) + "(元)\n";
        }
    }

    result += "----------------------\n";

    return result;

}

//  根据订单信息，满足促销的商品
function promotionItems(orderItemsInfo,promotions){

    let meetPMTConditionItems = new Array();

    for (let p of promotions) {
        if (p.type == "BUY_TWO_GET_ONE_FREE"){
            let promotionBarcode = p.barcodes;
            for (let item of orderItemsInfo){
                let promotionItem = promotionBarcode.find(element => (element == item.barcode))
                if (promotionItem != undefined && item.num >= 2 ) {
                    meetPMTConditionItems.push(item);
                }
            }
        }
    }
    return meetPMTConditionItems;
}


function printPromotiontItem(meetPMTConditionItems) {

    let result = "挥泪赠送商品：\n";

    for(let item of meetPMTConditionItems){
        result += "名称：" + item.name + "，数量：1"+item.unit+"\n";
    }

    result += "----------------------\n";
    return result;
}

// 商品总价
function getTotalCost(orderItemsInfo) {
    let totalCost = 0;
    for (let item of orderItemsInfo){
        ;
        totalCost += item.price * item.num;
    }
    return totalCost;
}

// 优惠了多少钱
function getSaveCost(meetPMTConditionItems) {

    let saveCost = 0;

    for ( let item of meetPMTConditionItems){
        saveCost += item.price;
    }

    return saveCost;
}
function loadAllItems() {
    return [
        {
            barcode: 'ITEM000000',
            name: '可口可乐',
            unit: '瓶',
            price: 3.00
        },
        {
            barcode: 'ITEM000001',
            name: '雪碧',
            unit: '瓶',
            price: 3.00
        },
        {
            barcode: 'ITEM000002',
            name: '苹果',
            unit: '斤',
            price: 5.50
        },
        {
            barcode: 'ITEM000003',
            name: '荔枝',
            unit: '斤',
            price: 15.00
        },
        {
            barcode: 'ITEM000004',
            name: '电池',
            unit: '个',
            price: 2.00
        },
        {
            barcode: 'ITEM000005',
            name: '方便面',
            unit: '袋',
            price: 4.50
        }
    ];
}

function loadPromotions() {
    return [
        {
            type: 'BUY_TWO_GET_ONE_FREE',
            barcodes: [
                'ITEM000000',
                'ITEM000001',
                'ITEM000005'
            ]
        }
    ];
}


// 是否有优惠

//  有 买2赠一

//   打印总计