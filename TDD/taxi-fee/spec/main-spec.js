

const main = require('../main/main');

var chai = require('chai');
var expect = chai.expect;

/*
我们考虑出租车计价问题，
出租车的运价是每公里0.8元，
八公里起会加收50%的每公里运价，
起步价是两公里以内6块，
停车等待时加收每分钟0.25元，
最后计价的时候司机会四舍五入只收整块钱。
*/
describe('taxi fee', function () {
    it("returns the distance value is less than or equal to 2", function () {
        let distance = 2;
        let waitTime = 0;
        let result = main(distance,waitTime);
        expect(result).to.equal('6');
    });


    it("returns the distance and the waitTime is minus", function () {
        let distance = -2;
        let waitTime = -6;
        let result = main(distance,waitTime);
        expect(result).to.equal('0');
    });

    it("returns the distance ranges from 2 to 8 (including 8)", function () {
        let distance = 6;
        let waitTime = 3;
        let result = main(distance,waitTime);
        expect(result).to.equal('10');
    });

    it("returns the distance value greater than 8 (exclusive 8)", function () {
        let distance = 15;
        let waitTime = 3;
        let result = main(distance,waitTime);

        expect(result).to.equal('20');
    });
});
