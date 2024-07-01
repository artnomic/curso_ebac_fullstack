const {
    option
} = require("grunt");

module.exports = function (grunt) {
    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),
        less: {
            development: {
                files: {
                    'main.css': 'main.less'
                }
            },
            production: {
                option: {
                    compress: true,
                },
                files: {
                    'main.min.css': 'main.less'
                }
            }
        },
        sass: {
            dist: {
                options: {
                    style: 'compressed'
                },
                files: {
                    'main2.css': 'main.scss'
                }
            }
        },
        concurrent: {
            target: ["less", "sass", "olaGrunt"]
        }
    })

    grunt.registerTask("olaGrunt", function () {
        const done = this.async();

        setTimeout(function () {
            console.log("Olá Grunt");
            done();
        }, 5000);
    })

    grunt.loadNpmTasks("grunt-contrib-less");
    grunt.loadNpmTasks("grunt-contrib-sass");
    grunt.loadNpmTasks("grunt-concurrent");


    grunt.registerTask("default", ["concurrent"]);
}