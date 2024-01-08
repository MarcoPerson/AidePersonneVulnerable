import * as React from 'react';

import { JsonView, allExpanded, darkStyles, defaultStyles } from 'react-json-view-lite';
import 'react-json-view-lite/dist/index.css';

const Result = ({data}) => {
  console.log(data)
  return (
    <React.Fragment>
      {/* <JsonView data={data} shouldExpandNode={allExpanded} style={defaultStyles} /> */}
      <JsonView data={data} shouldExpandNode={allExpanded} style={darkStyles} />
    </React.Fragment>
  );
};

export default Result;