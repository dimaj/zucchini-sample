# zucchini-sample
Sample project on how to use Zucchini

This project demonstrates how to create a Zucchini project. This is a fully working project that has 2 TestContexts: one for Chrome driver and one for Firefox driver. At the end, you'll end up with a HTML report which is found at: `target/zucchini-reports/feature-overview.html`

By default, this project is using a mac version of `chromedriver` which is located in the `lib` folder. If you are on a differnet OS, please refer to the comments in `pom.xml` on how to get the proper driver and how to configure it.  
