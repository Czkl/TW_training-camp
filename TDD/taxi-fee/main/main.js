module.exports = function main(distance,waitTime) {
    // console.log("Debug Info");
    let fee = 0;
    if (distance > 0) {
        fee = 6 + waitTime * 0.25;
    }
    if (distance > 2 && distance <= 8){
        fee += (distance - 2) * 0.8;
    }
    if(distance > 8){
        fee += (distance - 8) * (0.8 * 1.5) + (8 - 2)* 0.8;
    }

    // 四舍五入
    let result = fee.toFixed(0);

    return result;
};