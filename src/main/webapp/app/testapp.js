(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('BodyController', BodyController);

        BodyController.$inject = ['$scope'];

        function BodyController($scope){
            //var vm = this;
            $scope.user = "Shanmuga";
            //console.log(vm.user);
        }

})();