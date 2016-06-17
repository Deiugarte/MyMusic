(function() {
    'use strict';
    angular
        .module('refiereApp.fanProfile')
        .controller('fanProfileCtrl', fanProfileCtrl);

    fanProfileCtrl.$inject = ['FanaticSrv', '$state', '$window', '$scope'];

    function fanProfileCtrl(FanaticSrv, $state, $window, $scope) {
        var vm = this;
        vm.newUser = {};
        vm.genresList = {};
        vm.countriesList = {};
        getUserData();
        function getUserData(data){
          FanaticSrv.getUserData()
          .then(function(info){
            vm.newUser = info.data;
          })
        }
        function getGenresData(data){
          FanaticSrv.getGenresData()
          .then(function(info){
            vm.genresList = info.data;
          })
        }
        function getUbicationsList() {
          FanaticSrv.getUbicationsList()
            .then(function(ubicationData){
              vm.countriesList = ubicationData.data;
            })
        }
        vm.timeline = {
            publications: [{
                type: "noticia",
                title: "Universal Music comercializarálos Beatles en España",
                body: "Universal Music Spain, coincidmatos DVD y Blu-ray, ha llegado a un acuerdo con Apple Corp",
                date: "20/04/2015"
            }, {
                type: "noticia",
                title: "Se murió michael jackson",
                body: "GG legítimo",
                date: "12/03/2009"
            }, {
                type: "evento",
                title: "Ky-Mani Marley engalanará el Reggae Festival",
                body: "Un dia de estos tocas Ki MA ni marly",
                date: "25/12/2011",
                stars: 3,
                id: "ass",
                commentsAmount: 100
            }, {
                type: "evento",
                title: "Ky-Mani Marley engalanará el Reggae Festival",
                body: "Un dia de estos tocas Ki MA ni marly",
                date: "25/12/2011",
                stars: 5,
                commentsAmount: 20
            }]
        };

        vm.artistList = {
            artists: [{
                name: "Red Hot Chili Peppers",
                photo: "",
                country: "Estados Unidos",
                albumsAmount: 20,
                stars: 5,
                genres: [
                    "Rock",
                    "Pop",
                    "Funk",
                    "Alternativo"
                ],
                nextEvent: "Se presentan el 20 de octubre, en el Super Rock Festival",
            }, {
                name: "Bob Marley",
                photo: "",
                country: "Jamaica",
                albumsAmount: 5,
                stars: 3,
                genres: [
                    "Reggae",
                    "Ska",
                    "Funk",
                    "Dub",
                    "Quinto"
                ],
                nextEvent: "No tiene eventos próximos",
            }, {
                name: "Gorillaz",
                photo: "",
                country: "Estados Unidos",
                albumsAmount: 20,
                stars: 5,
                genres: [
                    "Rock alt",
                    "Rock electronico",
                    "Hip Hop",
                    "Alternativo",
                    "Dub"
                ],
                nextEvent: "Se presentarán en diciembre en el London UFK Festival",
            }, ]
        };





        $scope.filtersInvisible = true;
        $scope.showFilters = function() {
            if ($scope.filtersInvisible) {
                $scope.filtersInvisible = false;
                  getGenresData();
                  getUbicationsList();
            } else {
                $scope.filtersInvisible = true;
            }

        };
    }
})();
