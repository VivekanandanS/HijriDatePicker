var exec = require('cordova/exec');
exports.show = function (success, error) {
    console.log('Showing cAledndar');
    exec(success, error, 'hirijicalendar', 'show',[]);
};