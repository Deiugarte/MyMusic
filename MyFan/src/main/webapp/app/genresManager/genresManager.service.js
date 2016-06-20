(function() {
    'use strict';

    angular
        .module('refiereApp.genresManager')
        .service('GenresManagerSrv', GenresManagerSrv);

    GenresManagerSrv.$inject = ['$http'];

    /* @ngInject */
    function GenresManagerSrv($http) {
        var vm = this;
        vm.postAddNewGenres = postAddNewGenres;
        vm.getGenresList = getGenresList;

        function postAddNewGenres(data) {
            var url = 'http://localhost:8000/rest/v1/resources/addNewGenre';
            return $http.post(url, data);
        }

        function getGenresList(data) {
            var url = 'http://localhost:8000/rest/v1/resources/genreslist';
            return $http.get(url, data);
        }

    }
})();
