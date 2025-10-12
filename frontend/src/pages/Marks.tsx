import React, { useState, useEffect } from 'react';
import {
  Box,
  Card,
  CardContent,
  Typography,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  FormControl,
  InputLabel,
  Select,
  MenuItem,
  Chip,
  Grid,
} from '@mui/material';
import {
  Add,
  Edit,
  Delete,
  Search,
  Assessment,
  TrendingUp,
} from '@mui/icons-material';
import { DataGrid, GridColDef, GridActionsCellItem } from '@mui/x-data-grid';
import api from '../services/api';
import { toast } from 'react-toastify';

interface MarksData {
  id: number;
  studentId: number;
  studentName: string;
  subject: string;
  marksObtained: number;
  totalMarks: number;
  examType: string;
  semester: string;
  academicYear: string;
  percentage: number;
}

const Marks: React.FC = () => {
  const [marks, setMarks] = useState<MarksData[]>([]);
  const [loading, setLoading] = useState(true);
  const [open, setOpen] = useState(false);
  const [editingMarks, setEditingMarks] = useState<MarksData | null>(null);
  const [searchTerm, setSearchTerm] = useState('');
  const [filterSubject, setFilterSubject] = useState('');

  useEffect(() => {
    fetchMarks();
  }, []);

  const fetchMarks = async () => {
    try {
      // Mock data for demonstration
      const mockMarks: MarksData[] = [
        {
          id: 1,
          studentId: 1,
          studentName: 'John Doe',
          subject: 'Mathematics',
          marksObtained: 85,
          totalMarks: 100,
          examType: 'INTERNAL',
          semester: '1st',
          academicYear: '2023-24',
          percentage: 85,
        },
        {
          id: 2,
          studentId: 2,
          studentName: 'Jane Smith',
          subject: 'Physics',
          marksObtained: 92,
          totalMarks: 100,
          examType: 'EXTERNAL',
          semester: '1st',
          academicYear: '2023-24',
          percentage: 92,
        },
        {
          id: 3,
          studentId: 3,
          studentName: 'Mike Johnson',
          subject: 'Chemistry',
          marksObtained: 78,
          totalMarks: 100,
          examType: 'INTERNAL',
          semester: '2nd',
          academicYear: '2023-24',
          percentage: 78,
        },
      ];
      setMarks(mockMarks);
    } catch (error) {
      toast.error('Error fetching marks');
    } finally {
      setLoading(false);
    }
  };

  const handleAddMarks = () => {
    setEditingMarks(null);
    setOpen(true);
  };

  const handleEditMarks = (marks: MarksData) => {
    setEditingMarks(marks);
    setOpen(true);
  };

  const handleDeleteMarks = async (id: number) => {
    if (window.confirm('Are you sure you want to delete this marks record?')) {
      try {
        await api.delete(`/marks/${id}`);
        toast.success('Marks deleted successfully');
        fetchMarks();
      } catch (error) {
        toast.error('Error deleting marks');
      }
    }
  };

  const handleClose = () => {
    setOpen(false);
    setEditingMarks(null);
  };

  const filteredMarks = marks.filter(mark =>
    mark.studentName.toLowerCase().includes(searchTerm.toLowerCase()) ||
    mark.subject.toLowerCase().includes(searchTerm.toLowerCase()) ||
    mark.semester.toLowerCase().includes(searchTerm.toLowerCase())
  ).filter(mark =>
    filterSubject === '' || mark.subject === filterSubject
  );

  const getGradeColor = (percentage: number) => {
    if (percentage >= 90) return 'success';
    if (percentage >= 80) return 'primary';
    if (percentage >= 70) return 'warning';
    return 'error';
  };

  const getGrade = (percentage: number) => {
    if (percentage >= 90) return 'A+';
    if (percentage >= 80) return 'A';
    if (percentage >= 70) return 'B';
    if (percentage >= 60) return 'C';
    if (percentage >= 50) return 'D';
    return 'F';
  };

  const columns: GridColDef[] = [
    {
      field: 'studentName',
      headerName: 'Student Name',
      width: 150,
    },
    {
      field: 'subject',
      headerName: 'Subject',
      width: 120,
    },
    {
      field: 'marksObtained',
      headerName: 'Marks',
      width: 100,
      renderCell: (params) => (
        <Typography variant="body2" fontWeight="bold">
          {params.value}/{params.row.totalMarks}
        </Typography>
      ),
    },
    {
      field: 'percentage',
      headerName: 'Percentage',
      width: 120,
      renderCell: (params) => (
        <Chip
          label={`${params.value}%`}
          color={getGradeColor(params.value) as any}
          size="small"
        />
      ),
    },
    {
      field: 'grade',
      headerName: 'Grade',
      width: 100,
      renderCell: (params) => (
        <Chip
          label={getGrade(params.row.percentage)}
          color={getGradeColor(params.row.percentage) as any}
          variant="outlined"
          size="small"
        />
      ),
    },
    {
      field: 'examType',
      headerName: 'Exam Type',
      width: 120,
      renderCell: (params) => (
        <Chip
          label={params.value}
          color="primary"
          variant="outlined"
          size="small"
        />
      ),
    },
    {
      field: 'semester',
      headerName: 'Semester',
      width: 100,
    },
    {
      field: 'actions',
      type: 'actions',
      headerName: 'Actions',
      width: 120,
      getActions: (params) => [
        <GridActionsCellItem
          icon={<Edit />}
          label="Edit"
          onClick={() => handleEditMarks(params.row)}
        />,
        <GridActionsCellItem
          icon={<Delete />}
          label="Delete"
          onClick={() => handleDeleteMarks(params.row.id)}
        />,
      ],
    },
  ];

  return (
    <Box>
      <Box display="flex" justifyContent="space-between" alignItems="center" mb={3}>
        <Typography variant="h4">Marks Management</Typography>
        <Button
          variant="contained"
          startIcon={<Add />}
          onClick={handleAddMarks}
        >
          Add Marks
        </Button>
      </Box>

      <Grid container spacing={3} mb={3}>
        <Grid item xs={12} sm={6} md={3}>
          <Card>
            <CardContent>
              <Box display="flex" alignItems="center">
                <Assessment color="primary" sx={{ mr: 2, fontSize: 40 }} />
                <Box>
                  <Typography variant="h4" color="primary">
                    {marks.length}
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Total Records
                  </Typography>
                </Box>
              </Box>
            </CardContent>
          </Card>
        </Grid>
        <Grid item xs={12} sm={6} md={3}>
          <Card>
            <CardContent>
              <Box display="flex" alignItems="center">
                <TrendingUp color="success" sx={{ mr: 2, fontSize: 40 }} />
                <Box>
                  <Typography variant="h4" color="success.main">
                    {marks.length > 0 ? (marks.reduce((sum, mark) => sum + mark.percentage, 0) / marks.length).toFixed(1) : 0}%
                  </Typography>
                  <Typography variant="body2" color="text.secondary">
                    Average Score
                  </Typography>
                </Box>
              </Box>
            </CardContent>
          </Card>
        </Grid>
      </Grid>

      <Card>
        <CardContent>
          <Box display="flex" alignItems="center" gap={2} mb={2}>
            <TextField
              placeholder="Search marks..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              InputProps={{
                startAdornment: <Search />,
              }}
              sx={{ minWidth: 300 }}
            />
            <FormControl sx={{ minWidth: 150 }}>
              <InputLabel>Subject</InputLabel>
              <Select
                value={filterSubject}
                label="Subject"
                onChange={(e) => setFilterSubject(e.target.value)}
              >
                <MenuItem value="">All Subjects</MenuItem>
                <MenuItem value="Mathematics">Mathematics</MenuItem>
                <MenuItem value="Physics">Physics</MenuItem>
                <MenuItem value="Chemistry">Chemistry</MenuItem>
                <MenuItem value="English">English</MenuItem>
              </Select>
            </FormControl>
          </Box>

          <DataGrid
            rows={filteredMarks}
            columns={columns}
            loading={loading}
            pageSizeOptions={[5, 10, 25]}
            initialState={{
              pagination: {
                paginationModel: { pageSize: 10 },
              },
            }}
            disableRowSelectionOnClick
            sx={{ height: 400 }}
          />
        </CardContent>
      </Card>

      <Dialog open={open} onClose={handleClose} maxWidth="md" fullWidth>
        <DialogTitle>
          {editingMarks ? 'Edit Marks' : 'Add New Marks'}
        </DialogTitle>
        <DialogContent>
          <Box sx={{ pt: 2 }}>
            <FormControl fullWidth margin="normal">
              <InputLabel>Student</InputLabel>
              <Select label="Student">
                <MenuItem value="1">John Doe</MenuItem>
                <MenuItem value="2">Jane Smith</MenuItem>
                <MenuItem value="3">Mike Johnson</MenuItem>
              </Select>
            </FormControl>
            <FormControl fullWidth margin="normal">
              <InputLabel>Subject</InputLabel>
              <Select label="Subject">
                <MenuItem value="Mathematics">Mathematics</MenuItem>
                <MenuItem value="Physics">Physics</MenuItem>
                <MenuItem value="Chemistry">Chemistry</MenuItem>
                <MenuItem value="English">English</MenuItem>
              </Select>
            </FormControl>
            <Box display="flex" gap={2}>
              <TextField
                fullWidth
                label="Marks Obtained"
                type="number"
                margin="normal"
                required
              />
              <TextField
                fullWidth
                label="Total Marks"
                type="number"
                margin="normal"
                required
              />
            </Box>
            <FormControl fullWidth margin="normal">
              <InputLabel>Exam Type</InputLabel>
              <Select label="Exam Type">
                <MenuItem value="INTERNAL">Internal</MenuItem>
                <MenuItem value="EXTERNAL">External</MenuItem>
                <MenuItem value="ASSIGNMENT">Assignment</MenuItem>
                <MenuItem value="PROJECT">Project</MenuItem>
              </Select>
            </FormControl>
            <Box display="flex" gap={2}>
              <TextField
                fullWidth
                label="Semester"
                margin="normal"
                required
              />
              <TextField
                fullWidth
                label="Academic Year"
                margin="normal"
                required
              />
            </Box>
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button variant="contained">
            {editingMarks ? 'Update' : 'Create'}
          </Button>
        </DialogActions>
      </Dialog>
    </Box>
  );
};

export default Marks;
