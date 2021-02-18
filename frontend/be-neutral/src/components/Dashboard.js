import React from 'react'
import Paper from '@material-ui/core/Paper';
import {
    ArgumentAxis,
    Chart,
    BarSeries,
    PieSeries,
    Title,
} from '@devexpress/dx-react-chart-material-ui';
import { Animation } from '@devexpress/dx-react-chart';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
        paddingLeft: '20%',
        paddingRight: '20%'
    },
    paper: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary,
    },
}));

const data = [
    { month: 'Jan', value: 100 },
    { month: 'Feb', value: 99 },
    { month: 'March', value: 96 },
    { month: 'April', value: 94 },
    { month: 'May', value: 91 },
    { month: 'June', value: 88 },
    { month: 'July', value: 81 },
    { month: 'August', value: 50 },
    { month: 'September', value: 25 },
    { month: 'October', value: 12 },
    { month: 'November', value: 6 },
    { month: 'December', value: 1 },
];

const emisionData = [
    { item: 'Lights', area: 12 },
    { item: 'Laundry', area: 7 },
    { item: 'Water heating', area: 7 },
    { item: 'other factor', area: 7 },
    { item: 'other factor #2', area: 6 },
    { item: 'other factor #3', area: 5 },
    { item: 'Cooking', area: 2 },
    { item: 'House heating', area: 55 },
];

const absorptionData = [
    { item: 'My trees', area: 55 },
    { item: 'Carbon capture products', area: 30 },
    { item: 'Other stuff', area: 15 },
];

export default function FullWidthGrid() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <Grid container spacing={3}>
                <Grid item xs={12}>
                    <Paper className={classes.paper}>
                        <Chart
                            data={data}
                        >
                            <ArgumentAxis />
                            <Title
                                text="Progres over the course of time"
                            />
                            <BarSeries valueField="value" argumentField="month" />
                            <Animation />
                        </Chart>
                    </Paper>
                </Grid>
                <Grid item xs={12} sm={6}>
                    <Paper className={classes.paper}>
                        <Chart data={emisionData}>
                            <Title text="CO2 Emision" />
                            <PieSeries
                                valueField="area"
                                argumentField="item"
                            />
                            <Animation />
                        </Chart>
                    </Paper>
                </Grid>
                <Grid item xs={12} sm={6}>
                    <Paper className={classes.paper}>
                        <Chart data={absorptionData} >
                            <Title text="CO2 Absorbtion"/>
                            <PieSeries
                                valueField="area"
                                argumentField="item"
                            />
                            <Animation />
                        </Chart>
                    </Paper>
                </Grid>
                <Grid item xs={6} sm={6}>
                    <Paper className={classes.paper}>Reduce emision: </Paper>
                </Grid>
                <Grid item xs={6} sm={6}>
                    <Paper className={classes.paper}>Increase absorbtion</Paper>
                </Grid>
            </Grid>
        </div>
    );
}
