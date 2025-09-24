#!/bin/bash

# The Third Programmer - Kata Helper Script
# Usage: ./kata.sh <kata-name>

set -e

if [ $# -eq 0 ]; then
    echo "Usage: $0 <kata-name>"
    echo "Example: $0 fizz-buzz"
    exit 1
fi

KATA_NAME="kata-$1"
KATA_DIR="$KATA_NAME"
PACKAGE_PATH="src/main/java/com/thoughtworks/thethirdprogrammer/${1//-/}"
TEST_PATH="src/test/java/com/thoughtworks/thethirdprogrammer/${1//-/}"

echo "Creating new kata: $KATA_NAME"

# Create directory structure
mkdir -p "$KATA_DIR/$PACKAGE_PATH"
mkdir -p "$KATA_DIR/$TEST_PATH"

# Create README template
cat > "$KATA_DIR/README.md" << EOF
# Kata: $(echo $1 | sed 's/-/ /g' | sed 's/\b\w/\U&/g')

## Session Information
- **Date**: $(date +"%B %d, %Y")
- **Participants**: Nik Malykhin, Javier Lopez, GitHub Copilot
- **Kata Source**: [Add kata source URL here]

## Objective
[Describe the kata objective and rules]

## Trio Programming Session Notes

### AI Collaboration Patterns Discovered
_Document how GitHub Copilot contributed to this session_

### Code Quality Observations
_Note any refactoring decisions or clean code practices applied_

### Lessons Learned
_Insights about the trio programming dynamic for this kata_

## Implementation Notes
_Technical decisions and approach taken_
EOF

# Update settings.gradle
if ! grep -q "include '$KATA_NAME'" settings.gradle; then
    sed -i '' "/include 'kata-bowling-game'/a\\
include '$KATA_NAME'" settings.gradle
fi

echo "✅ Kata '$KATA_NAME' created successfully!"
echo "📝 Edit $KATA_DIR/README.md to add kata details"
echo "🚀 Run tests with: ./gradlew $KATA_NAME:test"
echo "🔧 Run continuous testing: ./gradlew $KATA_NAME:test --continuous"