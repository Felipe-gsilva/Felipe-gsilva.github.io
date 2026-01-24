const https = require('https');
const fs = require('fs');
const path = require('path');

const USERNAME = 'felipe-gsilva';
const OUTPUT_DIR = path.join(__dirname, '../public/resources/data');
const OUTPUT_FILE = path.join(OUTPUT_DIR, 'projects.json');

if (!fs.existsSync(OUTPUT_DIR)) {
  fs.mkdirSync(OUTPUT_DIR, { recursive: true });
}

const options = {
  hostname: 'api.github.com',
  path: `/users/${USERNAME}/repos?sort=updated&per_page=100`,
  method: 'GET',
  headers: {
    'User-Agent': 'Node.js Script',
    'Accept': 'application/vnd.github.v3+json'
  }
};

console.log(`Fetching repos for ${USERNAME}...`);

const req = https.request(options, (res) => {
  if (res.statusCode < 200 || res.statusCode >= 300) {
    return console.error('statusCode=', res.statusCode);
  }

  let body = [];
  res.on('data', (chunk) => {
    body.push(chunk);
  });

  res.on('end', () => {
    try {
      body = JSON.parse(Buffer.concat(body).toString());
    } catch (e) {
      console.error(e);
      return;
    }

    const projects = body
      .filter(repo => !repo.fork && !repo.archived) // Optional: filter out forks/archived
      .map(repo => ({
        id: repo.id,
        name: repo.name,
        description: repo.description,
        html_url: repo.html_url,
        homepage: repo.homepage,
        language: repo.language,
        stargazers_count: repo.stargazers_count,
        forks_count: repo.forks_count,
        updated_at: repo.updated_at
      }))
      .sort((a, b) => b.stargazers_count - a.stargazers_count); // Sort by stars

    fs.writeFileSync(OUTPUT_FILE, JSON.stringify(projects, null, 2));
    console.log(`Successfully saved ${projects.length} projects to ${OUTPUT_FILE}`);
  });
});

req.on('error', (e) => {
  console.error(e);
});

req.end();
