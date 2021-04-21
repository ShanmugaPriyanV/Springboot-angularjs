(function() {
    'use strict';

    angular
        .module('myApp')
        .controller('UserController', UserController);

        UserController.$inject = ['$scope', '$http'];

        function UserController($scope, $http){
            var vm = this;
            vm.user = {};
            vm.user.name = "Shanmuga";
            console.log(vm.user);
            refresh();
            vm.userList = [];
            vm.save = function(){
                $http.post('api/users',vm.user).then(function(res){
                    console.log(res);
                    refresh();
                });
            }

            function refresh(){
                $http.get('api/getUsers').then(function(res){
                    console.log(res);
                    vm.userList = res.data;
                });
            }

            vm.editUser = function(user){
               $http.get('api/editUser/'+user.id).then(function(res){
                   console.log(res.data);
                   vm.user = res.data;
               });
            }

            vm.deleteUser = function(user){
                $http.get('api/deleteUser/'+user.id).then(function(res){
                       //console.log(res.data);
                       //vm.user = res.data;
                       refresh();
                   });
            }

            vm.left = function(){
                console.log("shanmuga");
                var userv = {
                    "id": 5,
                    "name": "shadow",
                    "age": 25,
                    "salary": 45000
                };
                $http.put('api/testData/Update', userv).then(success,error);
            }
            function success(data){
                console.log("success");
                console.log(data);
            }
            function error(){
                console.log("error");
            }
        }

})();