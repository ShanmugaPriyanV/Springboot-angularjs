(function() {
    'use strict';

    angular
        .module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        console.log("fds");
        $stateProvider.state('app', {
            //parent: 'hello',
            url: '/',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/user/user.html',
                    controller: 'UserController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
