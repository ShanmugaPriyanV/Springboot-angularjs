(function() {
    'use strict';

    angular
        .module('myApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    /*function stateConfig($stateProvider) {
        $stateProvider.state('user', {
            parent: 'app',
            url: '/user',
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
    }*/

    function stateConfig($stateProvider) {
      var helloState = {
        name: 'hello',
        url: '/hello',
        //template: '<h3>hello world!</h3>'
        views: {
                        'content@': {
                            templateUrl: 'app/user/user.html',
                            controller: 'UserController',
                            controllerAs: 'vm'
                        }
                    }
      }

      var aboutState = {
        name: 'about',
        url: '/about',
        template: '<h3>Its the UI-Router hello world app!</h3>'
      }

      $stateProvider.state(helloState);
      $stateProvider.state(aboutState);
    };
})();
