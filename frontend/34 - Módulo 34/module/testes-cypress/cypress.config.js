const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
  reporter: 'mochawesome',
  reporterOptions: {
    reportDir: 'cypress/report',
    overwrite: true,
    hmtl: true,
    json: false,
    timestamp: 'ddmmyyyy_HHMMss'
  }
});
