/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./resources/js/app.js'],
  theme: {
    colors: {
      'bg1': '#211e20',
      'bg2': '#555568',
      'fg1': '#e9efec',
      'fg2': '#',
      'hl': '#fff'
    },
    extend: {
      fontFamily: {
        'NerdFont Jetbrains': ['Abril Fatface', 'serif']
      }
    },
  },
  plugins: [],
}
